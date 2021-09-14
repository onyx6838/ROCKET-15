package com.vti.controller;

import com.vti.dto.AccountDto;
import com.vti.dto.DepartmentDto;
import com.vti.dto.LoginInfoDto;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.IAccountService;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private IAccountService service;

    @GetMapping()
    public ResponseEntity<?> login(Principal principal) {
        String username = principal.getName();
        Account entity = service.getAccountByUsername(username);
        // convert entity to dto through principal java sercutity
        LoginInfoDto dto = new LoginInfoDto(entity.getId(), entity.getFullName());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
