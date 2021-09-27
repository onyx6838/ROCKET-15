package com.vti.controller;

import com.vti.dto.LoginInfoDto;
import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {

  @Autowired
  private IAccountService service;

  @GetMapping()
  public ResponseEntity<LoginInfoDto> login(Principal principal) {
    String username = principal.getName();
    Account entity = service.getAccountByUsername(username);
    // convert entity to dto through principal java security
    LoginInfoDto dto = new LoginInfoDto(entity.getId(), entity.getFullName());
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

}
