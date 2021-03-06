package com.vti.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vti.dto.authentication.LoginInfoDto;
import com.vti.dto.authentication.TokenRefreshResponse;
import com.vti.entity.Account;
import com.vti.entity.authentication.RefreshToken;
import com.vti.repository.IRefreshTokenRepository;
import com.vti.repository.IResetPasswordTokenRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class JWTTokenService implements IJWTTokenService {
    @Value("${jwt.token.prefix}")
    private String tokenPrefix;

    @Value("${jwt.token.authorization}")
    private String tokenAuthorization;

    @Value("${jwt.token.expired-time}")
    private long tokenExpiredTime;

    @Value("${jwt.token.secret}")   // key
    private String tokenSecret;

    @Value("${jwt.refresh-token.expired-time}")
    private long refreshTokenExpiredTime;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRefreshTokenRepository refreshTokenRepository;

    @Autowired
    private IResetPasswordTokenRepository resetPasswordTokenRepository;

    @Override
    public void addJWTTokenToHeader(HttpServletResponse response, String username) throws IOException {
        // get user info
        Account account = accountService.getAccountByUsername(username);
        // get jwt code
        String jwt = generateJWTFromUsername(username);
        String refreshToken = createNewRefreshToken(account);
        //convert account to dto
        LoginInfoDto userDto = modelMapper.map(account, LoginInfoDto.class);
        userDto.setToken(jwt);
        userDto.setRefreshToken(refreshToken);
        // convert to json
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(userDto);
        // add to response body
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        //response.addHeader(tokenAuthorization, tokenPrefix + " " + jwt);
    }

    @Override
    public Authentication parseTokenToUserInformation(HttpServletRequest request) {
        String jwt = request.getHeader(tokenAuthorization);

        if (jwt == null) {
            return null;
        }

        jwt = jwt.replace(tokenPrefix, "");

        if (!isValidJwt(jwt)) {
            return null;
        }

        // parse the token
        String username = parseJWTToUsername(jwt);

        Account user = accountService.getAccountByUsername(username);

        return user != null ?
                new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        AuthorityUtils.createAuthorityList(user.getRole())) :
                null;

    }

    private boolean isValidJwt(String jwt) {
        try {
            Jwts.parser().setSigningKey(createKeyFromSecretToken()).parseClaimsJws(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isValidRefreshToken(String refreshToken) {
        return refreshTokenRepository.existsByTokenAndExpiredDateGreaterThan(refreshToken, new Date());
    }

    @Override
    public boolean isValidResetPasswordToken(String resetPasswordToken) {
        return resetPasswordTokenRepository.existsByTokenAndExpiredDateGreaterThan(resetPasswordToken, new Date());
    }

    @Override
    public String createNewRefreshToken(Account account) {
        // create new refresh token
        String newToken = UUID.randomUUID().toString();
        RefreshToken token = new RefreshToken(newToken, account, refreshTokenExpiredTime);

        // create new token
        refreshTokenRepository.save(token);

        return newToken;
    }

    @Override
    public TokenRefreshResponse refreshToken(String refreshToken) {
        RefreshToken refreshTokenEntity = refreshTokenRepository.findByToken(refreshToken);
        Account account = refreshTokenEntity.getAccount();

        // create new token
        String newToken = generateJWTFromUsername(account.getUsername());
        String newRefreshToken = createNewRefreshToken(account);

        // remove old Refresh Token if exists
        refreshTokenRepository.deleteByToken(refreshToken);

        return TokenRefreshResponse.builder().token(newToken).refreshToken(newRefreshToken).id(account.getId())
                .fullName(account.getFullName()).role(account.getRole()).build();
    }

    private String generateJWTFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiredTime))
                .signWith(SignatureAlgorithm.HS512, createKeyFromSecretToken())
                .compact();
    }
    @SuppressWarnings("unused")
    private String generateJWTFromUsername(LoginInfoDto dto) {
        return Jwts.builder()
                .setSubject(dto.getFullName())
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiredTime))
                .signWith(SignatureAlgorithm.HS512, createKeyFromSecretToken())
                .claim("user-details", dto)
                .compact();
    }

    private String parseJWTToUsername(String jwt) {
        return Jwts.parser()
                .setSigningKey(createKeyFromSecretToken())
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }

    private Key createKeyFromSecretToken() {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenSecret);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
    }
}