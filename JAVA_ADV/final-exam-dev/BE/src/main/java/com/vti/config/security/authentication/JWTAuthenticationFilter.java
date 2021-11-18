package com.vti.config.security.authentication;

import com.vti.service.IAccountService;
import com.vti.service.IJWTTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private IJWTTokenService jwtTokenService;

    @Autowired
    private IAccountService accountService;

    public JWTAuthenticationFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String role = accountService.getAccountByUsername(username).getRole();
        UsernamePasswordAuthenticationToken s = new UsernamePasswordAuthenticationToken(
                username, password,
                AuthorityUtils.createAuthorityList(role)
        );
        return getAuthenticationManager().authenticate(s);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        jwtTokenService.addJWTTokenToHeader(response, authResult.getName());
    }
}
