package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.authentication.ResetPasswordToken;
import com.vti.form.GroupFormForUpdating;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Account getAccountByUsername(String username);

    Account findById(int id);

    void createAccount(Account account);

    Account findAccountByEmail(String email);

    void activeAccount(String token);

    void sendConfirmAccountRegistrationViaEmail(String email);

    void resetPassword(String token, String newPassword);

    ResetPasswordToken getResetPasswordToken(String token);

    void deleteResetPasswordTokenByAccountId(int accountId);
}
