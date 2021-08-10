package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountController {
    private IAccountService accountService;

    public AccountController() throws IOException, SQLException {
        this.accountService = new AccountService();
    }

    public List<Account> getListAccounts() throws SQLException {
        return accountService.getListAccounts();
    }

    public void createAccount(Account account) throws SQLException {
        accountService.createAccount(account);
    }

    public Account getAccountById(int id) throws SQLException {
        return accountService.getAccountById(id);
    }

    public boolean isAccountExists(String username) throws SQLException {
        return accountService.isAccountExists(username);
    }

    public boolean isAccountExists(int id) throws SQLException {
        return accountService.isAccountExists(id);
    }

    public void updateAccountById(int id, Account accountUpdate) throws SQLException {
        accountService.updateAccountById(id, accountUpdate);
    }

    public void deleteAccount(int id) throws SQLException {
        accountService.deleteAccount(id);
    }
}
