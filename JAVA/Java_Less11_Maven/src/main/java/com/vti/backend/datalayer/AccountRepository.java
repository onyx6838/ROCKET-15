package com.vti.backend.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.utils.JdbcUtils;
import com.vti.utils.SqlUtils;
import com.vti.utils.properties.MessageProperties;

/**
 * This class is account repository.
 *
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class AccountRepository implements IAccountRepository {

    private MessageProperties messageProperties;

    public AccountRepository() throws IOException {
        messageProperties = new MessageProperties();
    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#getListAccounts()
     */
    @Override
    public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {

        List<Account> accounts = new ArrayList<>();

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // create a statement object
        String sql = "SELECT AccountId, Email, Username, FullName FROM `Account`";
        Statement statement = connection.createStatement();

        // execute query
        ResultSet resultSet = statement.executeQuery(sql);

        // Handing result set
        while (resultSet.next()) {
            Account account = new Account(
                    resultSet.getInt("AccountId"),
                    resultSet.getString("Email"),
                    resultSet.getString("Username"),
                    resultSet.getString("Fullname"));

            accounts.add(account);
        }

        // disconnect
        JdbcUtils.getInstance().disconnect();
        return accounts;

    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#getUserByID(int)
     */
    @Override
    public Account getAccountByID(int id) throws Exception {

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // Create a statement object
        String sql = "SELECT * FROM Account WHERE AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set parameter
        //preparedStatement.setInt(1, id);

        SqlUtils.addParams(preparedStatement, id);

        // Step 4: execute query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Step 5: handling result set
        if (resultSet.next()) {
            Account account = new Account(
                    resultSet.getInt("AccountId"),
                    resultSet.getString("Email"),
                    resultSet.getString("Username"),
                    resultSet.getString("FullName"));

            // disconnect
            JdbcUtils.getInstance().disconnect();
            return account;

        } else {
            // disconnect
            JdbcUtils.getInstance().disconnect();
            throw new Exception(messageProperties.getProperty("account.getAccountByID.cannotFindAccountById") + id);
        }
    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#isAccountExists(java.lang.String)
     */
    @Override
    public boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException {

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // Create a statement object
        String sql = "SELECT 1 FROM `Account` WHERE Username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set parameter
        preparedStatement.setString(1, username);

        // Step 4: execute query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Step 5: handling result set
        if (resultSet.next()) {
            // disconnect
            JdbcUtils.getInstance().disconnect();
            return true;

        } else {
            // disconnect
            JdbcUtils.getInstance().disconnect();
            return false;
        }
    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#isAccountExists(int)
     */
    @Override
    public boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException {

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // Create a statement object
        String sql = "SELECT 1 FROM Account WHERE AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set parameter
        preparedStatement.setInt(1, id);

        // Step 4: execute query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Step 5: handling result set
        if (resultSet.next()) {
            // disconnect
            JdbcUtils.getInstance().disconnect();
            return true;

        } else {
            // disconnect
            JdbcUtils.getInstance().disconnect();
            return false;
        }
    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#createUser(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void createAccount(String email, String username, String fullName) throws Exception {

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // if not exist
        // Create a statement object
        String sql = "INSERT INTO Account (Email, Username, Fullname)"
                + "VALUE              (   ? ,   ?   	,   ?	)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set parameter
//        preparedStatement.setString(1, email);
//        preparedStatement.setString(2, username);
//        preparedStatement.setString(3, fullName);

        SqlUtils.addParams(preparedStatement, email, username, fullName);

        // Step 4: execute query
        int check = preparedStatement.executeUpdate();

        // Check create success or false
        System.out.println(
                check > 0 ?
                        messageProperties.getProperty("account.insert.complete")
                        : messageProperties.getProperty("account.insert.false"));

        // disconnect
        JdbcUtils.getInstance().disconnect();
    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#updateAccountByID(int, java.lang.String)
     */
    @Override
    public void updateAccountByID(int id, String newFullName) throws Exception {

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // Create a statement object
        String sql = "UPDATE Account SET FullName = ? WHERE AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set parameter
        preparedStatement.setString(1, newFullName);
        preparedStatement.setInt(2, id);

        // Step 4: execute query
        int check = preparedStatement.executeUpdate();

        // Check check success or false
        System.out.println(
                check > 0 ?
                        messageProperties.getProperty("account.update.complete")
                        : messageProperties.getProperty("account.update.false"));

        // disconnect
        JdbcUtils.getInstance().disconnect();
    }

    /*
     * @see com.vti.backend.datalayer.IAccountRepository#deleteAccount(int)
     */
    @Override
    public void deleteAccount(int id) throws Exception {

        // get connection
        Connection connection = JdbcUtils.getInstance().connect();

        // Create a statement object
        String sql = "DELETE FROM Account WHERE AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // set parameter
        preparedStatement.setInt(1, id);

        // Step 4: execute query
        int check = preparedStatement.executeUpdate();

        // Check check success or false
        System.out.println(
                check > 0 ?
                        messageProperties.getProperty("account.delete.complete")
                        : messageProperties.getProperty("account.delete.false"));

        // disconnect
        JdbcUtils.getInstance().disconnect();
    }

}
