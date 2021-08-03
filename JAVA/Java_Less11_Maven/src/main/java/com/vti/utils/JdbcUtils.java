package com.vti.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.vti.utils.properties.DatabaseProperties;

public class JdbcUtils {

    private Connection connection;

    private static JdbcUtils instance;  // singleton pattern

    private JdbcUtils() throws IOException, SQLException {
        try {
            DatabaseProperties databaseproperties = new DatabaseProperties();
            Class.forName(databaseproperties.getProperty("driver"));
            String url = databaseproperties.getProperty("url");
            String username = databaseproperties.getProperty("username");
            String password = databaseproperties.getProperty("password");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
    }

    public Connection connect() {
        return connection;
    }

    public static JdbcUtils getInstance() throws IOException, SQLException {
        if (instance == null) {
            instance = new JdbcUtils();
        } else if (instance.connect().isClosed()) {
            instance = new JdbcUtils();
        }
        return instance;
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
