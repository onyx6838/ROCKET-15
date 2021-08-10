package com.vti.dao;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;
import com.vti.utils.SqlUtils;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private JdbcUtils jdbcUtils;

    public AccountDao() throws SQLException, IOException {
        jdbcUtils = JdbcUtils.getInstance();
    }

    public List<Account> getAccounts() throws SQLException {
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
        jdbcUtils.disconnect();
        return accounts;
    }

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
                    resultSet.getDate("a.CreateDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            );
            jdbcUtils.disconnect();
            return account;
        } else {
            jdbcUtils.disconnect();
            System.out.println("Cannot find account which has id = " + id);
            throw new SQLException("Cannot find account with id");
        }
    }

    public boolean isUserNameExists(String userName) throws SQLException {
        try {
            Connection connection = jdbcUtils.connect();
            String sql = "SELECT 1 FROM account WHERE Username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } finally {
            jdbcUtils.disconnect();
        }
    }

    public void createAccount(Account account) throws SQLException {
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
        System.out.println(affected > 0 ? "Insert Account com" : "Failure Account depart");
        jdbcUtils.disconnect();
    }

    // UPDATE - TODO

    public void deleteAccount(int id) throws SQLException {
        Connection connection = jdbcUtils.connect();
        String sql = "DELETE FROM `account` WHERE `AccountID` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int affected = preparedStatement.executeUpdate();
        System.out.println(affected > 0 ? "Delete Account com" : "Failure Account depart");
        jdbcUtils.disconnect();
    }

    public void deleteAccountByDepartmentId(int id) throws SQLException {
        Connection connection = jdbcUtils.connect();
        String sql = "DELETE FROM `account` WHERE `DepartmentID` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int affected = preparedStatement.executeUpdate();
        System.out.println(affected > 0 ? "Delete Account com" : "Failure Account depart");
        jdbcUtils.disconnect();
    }
}
