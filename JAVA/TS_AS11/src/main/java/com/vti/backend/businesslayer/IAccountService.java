package com.vti.backend.businesslayer;

import com.vti.entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    List<Account> getListAccounts() throws SQLException, IOException;

    void createAccount(Account account) throws SQLException, IOException;

    Account getAccountById(int id) throws SQLException, IOException;

    boolean isAccountExists(String username) throws SQLException, IOException;

    boolean isAccountExists(int id) throws SQLException, IOException;

    void updateAccountById(int id, Account accountUpdate) throws SQLException, IOException;

    void deleteAccount(int id) throws SQLException, IOException;
}
