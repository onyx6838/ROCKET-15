package com.vti.controller;

import com.vti.dto.authentication.RegistrationAccountDto;
import com.vti.dto.authentication.TokenRefreshRequest;
import com.vti.dto.authentication.TokenRefreshResponse;
import com.vti.entity.Account;
import com.vti.form.GroupFormForUpdating;
import com.vti.service.IAccountService;
import com.vti.service.IJWTTokenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    // confirm
    @GetMapping("/userRegistrationConfirmRequest")
    // validate: email exists, email not active
    public ResponseEntity<?> sendConfirmRegistrationViaEmail(@RequestParam String email) {

        accountService.sendConfirmAccountRegistrationViaEmail(email);

        return new ResponseEntity<>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
    }

}
