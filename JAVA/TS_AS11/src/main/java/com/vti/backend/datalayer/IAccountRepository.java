package com.vti.backend.datalayer;

import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {
    List<Account> getListAccounts() throws SQLException;

    void createAccount(Account account) throws SQLException;

    Account getAccountById(int id) throws SQLException;

    boolean isAccountExists(String username) throws SQLException;

    boolean isAccountExists(int id) throws SQLException;

    void updateAccountById(int id, Account accountUpdate) throws SQLException;

    void deleteAccount(int id) throws SQLException;
}
