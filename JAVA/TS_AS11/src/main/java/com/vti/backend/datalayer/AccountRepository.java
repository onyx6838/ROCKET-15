package com.vti.backend.datalayer;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;
import com.vti.utils.SqlUtils;
import com.vti.utils.properties.MessageProperties;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private MessageProperties messageProperties;
    private JdbcUtils jdbcUtils;

    public AccountRepository() throws IOException, SQLException {
        this.messageProperties = new MessageProperties();
        jdbcUtils = JdbcUtils.getInstance();
    }

    @Override
    public List<Account> getListAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        Connection connection = jdbcUtils.connect();

        String sql = "SELECT a.AccountID,a.Email,a.Username,a.Fullname,a.CreateDate,d.* " +
                "FROM account a JOIN department d ON a.DepartmentID = d.DepartmentID ";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Account account = new Account(
                    resultSet.getInt("a.AccountID"),
                    resultSet.getString("a.Email"),
                    resultSet.getString("a.Username"),
                    resultSet.getString("a.Fullname"),
                    new Department(
                            resultSet.getInt("d.DepartmentID"),
                            resultSet.getString("d.DepartmentName")
                    ),
                    LocalDate.parse(resultSet.getString("a.CreateDate"))
            );
            accounts.add(account);
        }
        return accounts;

    }

    @Override
    public void createAccount(Account account) throws SQLException {
        try {
            Connection connection = jdbcUtils.connect();
            String sql = "INSERT INTO `account`(`AccountID`, `Email`, `Username`, `Fullname`, `DepartmentID`, `CreateDate`)  " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SqlUtils.addParams(preparedStatement,
                    account.getId(),
                    account.getEmail(),
                    account.getUserName(),
                    account.getFullName(),
                    account.getDepartment().getId(),
                    Date.from(account.getCreateDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
            );

            int affected = preparedStatement.executeUpdate();
            System.out.println(affected > 0 ?
                    messageProperties.getProperty("account.insert.complete")
                    : messageProperties.getProperty("account.insert.false"));
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public Account getAccountById(int id) throws SQLException {

        Connection connection = jdbcUtils.connect();
        String sql = "SELECT a.AccountID,a.Email,a.Username,a.Fullname,a.CreateDate,d.* From account a JOIN department d" +
                " ON a.DepartmentID = d.DepartmentID " +
                " WHERE a.AccountID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Account account = new Account(
                    resultSet.getInt("a.AccountID"),
                    resultSet.getString("a.Email"),
                    resultSet.getString("a.Username"),
                    resultSet.getString("a.Fullname"),
                    new Department(
                            resultSet.getInt("d.DepartmentID"),
                            resultSet.getString("d.DepartmentName")
                    ),
                    LocalDate.parse(resultSet.getString("a.CreateDate"))
            );
            return account;
        } else {
            throw new SQLException(messageProperties.getProperty("account.getAccountByID.cannotFindAccountById") + id);
        }

    }

    @Override
    public boolean isAccountExists(String username) throws SQLException {
        try {
            Connection connection = jdbcUtils.connect();
            String sql = "SELECT 1 FROM account WHERE Username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public boolean isAccountExists(int id) throws SQLException {
        try {
            Connection connection = jdbcUtils.connect();
            String sql = "SELECT 1 FROM account WHERE AccountID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public void updateAccountById(int id, Account accountUpdate) throws SQLException {
        try {
            Connection connection = jdbcUtils.connect();
            String sql = "UPDATE `account` SET " +
                    "`Email` = ?, `Username` = ?, `Fullname` = ?, `DepartmentID` = ?, `CreateDate` = ? WHERE `AccountID` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SqlUtils.addParams(preparedStatement,
                    accountUpdate.getId(),
                    accountUpdate.getEmail(),
                    accountUpdate.getUserName(),
                    accountUpdate.getFullName(),
                    accountUpdate.getDepartment().getId(),
                    Date.from(accountUpdate.getCreateDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    id
            );

            int affected = preparedStatement.executeUpdate();
            System.out.println(affected > 0 ? messageProperties.getProperty("account.update.complete")
                    : messageProperties.getProperty("account.update.false"));
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        try {
            Connection connection = jdbcUtils.connect();
            String sql = "DELETE FROM `account` WHERE `AccountID` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int affected = preparedStatement.executeUpdate();
            System.out.println(affected > 0 ? messageProperties.getProperty("account.delete.complete")
                    : messageProperties.getProperty("account.delete.false"));
        } finally {
            jdbcUtils.disconnect();
        }
    }
}
