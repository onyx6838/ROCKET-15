package com.testjdbc;

import java.sql.*;

public class Main1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/TestingSystem_jdbc_1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
        String username = "root";
        String password = "123qwe123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        //String sql = "SELECT id,username,email FROM `User`";
        String sql = "INSERT INTO `Group` (`name`, `author_ID`)" +
                     "VALUE (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // with param '?'
        String groupName = "java test";
        int authorId = 5;

        preparedStatement.setString(1, groupName);
        preparedStatement.setInt(2, authorId);

        int effectedAmount = preparedStatement.executeUpdate(); // change data query
        System.out.println("Effect record Amount " + effectedAmount);
    }
}
