package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountController {
    private IAccountService accountService;

    public AccountController() {
        this.accountService = new AccountService();
    }

    public List<Account> getListAccounts() throws SQLException, IOException {
        return accountService.getListAccounts();
    }

    public void createAccount(Account account) throws SQLException, IOException {
        accountService.createAccount(account);
    }

    public Account getAccountById(int id) throws SQLException, IOException {
        return accountService.getAccountById(id);
    }

    public boolean isAccountExists(String username) throws SQLException, IOException {
        return accountService.isAccountExists(username);
    }

    public boolean isAccountExists(int id) throws SQLException, IOException {
        return accountService.isAccountExists(id);
    }

    public void updateAccountById(int id, Account accountUpdate) throws SQLException, IOException {
        accountService.updateAccountById(id, accountUpdate);
    }

    public void deleteAccount(int id) throws SQLException, IOException {
        accountService.deleteAccount(id);
    }
}
