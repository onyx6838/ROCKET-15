package com.vti.backend.datalayer;

import com.vti.entity.User;
import com.vti.utils.JdbcUtils;
import com.vti.utils.properties.MessageProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    private MessageProperties messageProperties;
    private JdbcUtils jdbcUtils;

    public UserRepository() throws IOException, SQLException {
        this.messageProperties = new MessageProperties();
        jdbcUtils = JdbcUtils.getInstance();
    }

    @Override
    public User login(String email, String password) throws SQLException {
        Connection connection = jdbcUtils.connect();

        String sql = "SELECT * FROM `user` WHERE `email` = ? AND `password` = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int userId = resultSet.getInt("id");
            String fullName = resultSet.getString("fullName");
            String passWord = resultSet.getString("password");

            User user = new User(userId, fullName, email, passWord);
            return user;
        } else {
            jdbcUtils.disconnect();
            throw new SQLException(messageProperties.getProperty("user.login.cannotLogin"));
        }
    }
}
