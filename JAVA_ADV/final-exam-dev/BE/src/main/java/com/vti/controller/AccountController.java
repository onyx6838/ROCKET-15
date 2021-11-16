package com.vti.controller;

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

    @GetMapping("/resetPasswordRequest")
    public ResponseEntity<?> requestResetPasswordViaEmail(
            @UserEmailExists @Param(value = "email") String email) {


        return new ResponseEntity<>("We have sent 1 email. Please check email to reset account!", HttpStatus.OK);
    }

    @GetMapping("/resetPassword")
    public ResponseEntity<?> resetPasswordViaEmail(
            @ResetPasswordTokenValid @Param(value = "token") String token,
            @Param(value = "newPassword") String newPassword) {

        // reset password
        //service.resetPassword(token, newPassword);

        return new ResponseEntity<>("Reset password success!", HttpStatus.OK);
    }

}
