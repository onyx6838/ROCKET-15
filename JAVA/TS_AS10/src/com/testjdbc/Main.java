package com.testjdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/TestingSystem_jdbc_1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
        String username = "root";
        String password = "123qwe123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        //String sql = "SELECT id,username,email FROM `User`";
        String sql = "INSERT INTO `Group` (`name`, `author_ID`)" +
                     "VALUE ('Java Senior', 4)";
        Statement statement = connection.createStatement();
        //ResultSet resultSet = statement.executeQuery(sql); select query
        int effectedAmount = statement.executeUpdate(sql); // change data query

        /*while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("email") + "\n");
        }*/  // sql select query

        System.out.println("Effect record Amount " + effectedAmount);
    }
}
