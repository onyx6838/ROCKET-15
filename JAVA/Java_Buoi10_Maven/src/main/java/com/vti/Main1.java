package com.vti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Main1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Class.forName(properties.getProperty("driver"));
        Connection connection = DriverManager.getConnection(url, username, password);

        //String sql = "SELECT id,username,email FROM `User`";
        String sql = "INSERT INTO `Group` (`name`, `author_ID`)" +
                "VALUE (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // with param '?'
        String groupName = "java test7";
        int authorId = 5;

        preparedStatement.setString(1, groupName);
        preparedStatement.setInt(2, authorId);

        int effectedAmount = preparedStatement.executeUpdate(); // change data query
        System.out.println("Effect record Amount " + effectedAmount);
    }
}
