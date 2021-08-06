package com.vti.backend;

import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;
import com.vti.utils.properties.DatabaseProperties;

import java.io.IOException;
import java.sql.*;

public class Exercise1 {
    public void Ques1() throws IOException, ClassNotFoundException, SQLException {
        DatabaseProperties databaseproperties = new DatabaseProperties();
        Class.forName(databaseproperties.getProperty("driver"));
        String url = databaseproperties.getProperty("url");
        String username = databaseproperties.getProperty("username");
        String password = databaseproperties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println("Success");
    }

    public void Ques2() throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "SELECT PositionID, PositionName from position";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.print("Pos Id: " + resultSet.getInt("PositionID") +
                    " | PositionName: " + resultSet.getString("PositionName") + "\n");
        }
    }

    public void Ques3() throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "INSERT INTO `java_ts_as10`.`position`(`PositionName`) " +
                "VALUES (?)";
        String name = ScannerUtils.inputString("Incorrect Input");

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        int Affected = preparedStatement.executeUpdate();

        System.out.println("Affected rows: " + Affected);
        JdbcUtils.getInstance().disconnect();
    }

    public void Ques4() throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "UPDATE Postion SET PositionName = ? WHERE PostionID = ?";
        String name = ScannerUtils.inputString("Incorrect Input");

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, 5); // id = 5
        int Affected = preparedStatement.executeUpdate();

        System.out.println("Affected rows: " + Affected);
    }

    public void Ques5() throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "DELETE FROM Postion WHERE PostionID = ?";
        int idDelete = (int) ScannerUtils.inputPreventPositive("Incorrect Input", Integer.class);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, idDelete);
        int Affected = preparedStatement.executeUpdate();

        System.out.println("Affected rows: " + Affected);
    }
}
