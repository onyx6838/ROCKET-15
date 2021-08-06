package com.vti.dao;

import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public List<Department> getDepartments() throws SQLException, IOException {
        List<Department> departments = new ArrayList<>();
        Connection connection = JdbcUtils.getInstance().connect();

        String sql = "SELECT * FROM Department";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Department department = new Department(resultSet.getInt(1), resultSet.getString(2));
            departments.add(department);
        }
        JdbcUtils.getInstance().disconnect();
        return departments;
    }

    public Department getDepartmentById(int id) throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Department department = new Department(resultSet.getInt(1), resultSet.getString(2));
            JdbcUtils.getInstance().disconnect();
            return department;
        } else {
            JdbcUtils.getInstance().disconnect();
            System.out.println("Cannot find department which has id = " + id);
            throw new SQLException("Cannot find department with id");
        }
    }

    public boolean isDepartmentNameExists(String name) throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "SELECT 1 FROM Department WHERE DepartmentName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            JdbcUtils.getInstance().disconnect();
            return true;
        } else {
            JdbcUtils.getInstance().disconnect();
            return false;
        }
    }

    public void createDepartment(String name) throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "INSERT INTO Department (DepartmentName) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        int affected = preparedStatement.executeUpdate();
        System.out.println(affected > 0 ? "Insert Depart com" : "Failure insert depart");
        JdbcUtils.getInstance().disconnect();
    }

    public void updateDepartmentName(int id, String newName) throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "UPDATE `department` SET `DepartmentName` = ? WHERE `DepartmentID` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, id);

        int affected = preparedStatement.executeUpdate();
        System.out.println(affected > 0 ? "Update Depart com" : "Failure update depart");
        JdbcUtils.getInstance().disconnect();
    }

    public void deleteDepartment(int id) throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "DELETE FROM `department` WHERE `DepartmentID` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int affected = preparedStatement.executeUpdate();
        System.out.println(affected > 0 ? "Delete Depart com" : "Failure Delete depart");
        JdbcUtils.getInstance().disconnect();
    }

    public void deleteDepartmentUsingProcedure(int id) throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        String sql = "{CALL sp_delete_department(?)}";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int affected = preparedStatement.executeUpdate();
        System.out.println(affected > 0 ? "Delete Depart com" : "Failure Delete depart");
        JdbcUtils.getInstance().disconnect();
    }
}
