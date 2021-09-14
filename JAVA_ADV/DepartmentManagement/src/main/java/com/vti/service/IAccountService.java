package com.vti.service;

import com.vti.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Account getAccountByUsername(String username);
}
