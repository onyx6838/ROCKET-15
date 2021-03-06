package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    public AccountService() throws IOException, SQLException {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public List<Account> getListAccounts() throws SQLException {
        return accountRepository.getListAccounts();
    }

    @Override
    public void createAccount(Account account) throws SQLException {
        accountRepository.createAccount(account);
    }

    @Override
    public Account getAccountById(int id) throws SQLException {
        return accountRepository.getAccountById(id);
    }

    @Override
    public boolean isAccountExists(String username) throws SQLException {
        return accountRepository.isAccountExists(username);
    }

    @Override
    public boolean isAccountExists(int id) throws SQLException {
        return accountRepository.isAccountExists(id);
    }

    @Override
    public void updateAccountById(int id, Account accountUpdate) throws SQLException {
        accountRepository.updateAccountById(id, accountUpdate);
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        accountRepository.deleteAccount(id);
    }
}
