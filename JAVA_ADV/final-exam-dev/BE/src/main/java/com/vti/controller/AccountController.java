package com.vti.controller;

import com.vti.dto.ChangePublicProfileDto;
import com.vti.dto.ProfileDto;
import com.vti.dto.authentication.RegistrationAccountDto;
import com.vti.dto.authentication.TokenRefreshRequest;
import com.vti.dto.authentication.TokenRefreshResponse;
import com.vti.entity.Account;
import com.vti.service.IAccountService;
import com.vti.service.IJWTTokenService;
import com.vti.validation.form.account.ResetPasswordTokenValid;
import com.vti.validation.form.account.UserEmailExists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/accounts")
@Validated
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IJWTTokenService jwtTokenService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/profile")
    // validate: check exists, check not expired
    public ResponseEntity<?> getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // get username from token
        String username = authentication.getName();

        // get user info
        Account account = accountService.getAccountByUsername(username);

        // convert user entity to user dto
        ProfileDto profileDto = modelMapper.map(account, ProfileDto.class);

        return new ResponseEntity<>(profileDto, HttpStatus.OK);
    }

    @PutMapping("/profile")
    // validate: check exists, check not expired
    public ResponseEntity<?> changeUserProfile(@RequestBody ChangePublicProfileDto dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // get username from token
        String username = authentication.getName();

        accountService.changeUserProfile(username, dto);

        return new ResponseEntity<>("Change Profile Successfully!", HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    // validate: check exists, check not expired
    public ResponseEntity<?> existsUserByEmail(@PathVariable(name = "email") String email) {

        boolean result = accountService.existsByEmail(email);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/userName/{userName}")
    // validate: check exists, check not expired
    public ResponseEntity<?> existsUserByUserName(@PathVariable(name = "userName") String userName) {

        boolean result = accountService.existsByUsername(userName);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // refresh token
    @PostMapping("/token/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshRequest refreshToken) {
        if (!jwtTokenService.isValidRefreshToken(refreshToken.getRefreshToken())) {
            return new ResponseEntity<>("Refresh Token is invalid!", HttpStatus.SERVICE_UNAVAILABLE);
        }

        TokenRefreshResponse newTokenDto = jwtTokenService.refreshToken(refreshToken.getRefreshToken());
        return new ResponseEntity<>(newTokenDto, HttpStatus.OK);
    }

    // create user
    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody RegistrationAccountDto dto) {
        Account account = modelMapper.map(dto, Account.class);
        // create User
        accountService.createAccount(account);

        return new ResponseEntity<>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
    }

    @GetMapping("/activeUser")
    // validate: check exists, check not expired
    public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {

        // active user
        accountService.activeAccount(token);

        return new ResponseEntity<>("Active success!", HttpStatus.OK);
    }

    // resend confirm
    @GetMapping("/userRegistrationConfirmRequest")
    // validate: email exists, email not active
    public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {
        accountService.sendConfirmAccountRegistrationViaEmail(email);

        return new ResponseEntity<>("We have sent an email. Please check email to active account!", HttpStatus.OK);
    }

    @GetMapping("/resetPasswordRequest")
    public ResponseEntity<?> requestResetPasswordViaEmail(
            @UserEmailExists @Param(value = "email") String email) {
        accountService.resetPasswordViaEmail(email);
        return new ResponseEntity<>("We have sent 1 email. Please check email to reset account!", HttpStatus.OK);
    }

    // resend reset password
    @GetMapping("/resendResetPassword")
    // validate: email exists, email not active
    public ResponseEntity<?> resendResetPasswordViaEmail(@RequestParam String email) {

        accountService.resetPasswordViaEmail(email);

        return new ResponseEntity<>("We have sent an email. Please check email to reset password!", HttpStatus.OK);
    }

    @GetMapping("/resetPassword")
    public ResponseEntity<?> resetPasswordViaEmail(
            @ResetPasswordTokenValid @Param(value = "token") String token,
            @Param(value = "newPassword") String newPassword) {
        // reset password
        accountService.resetPassword(token, newPassword);

        return new ResponseEntity<>("Reset password success!", HttpStatus.OK);
    }
}
