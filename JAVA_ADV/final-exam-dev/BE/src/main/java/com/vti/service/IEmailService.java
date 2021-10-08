package com.vti.service;

import com.vti.entity.Account;

public interface IEmailService {
    void sendRegistrationUserConfirm(String email);

    void sendResetPassword(Account account, String token);
}
