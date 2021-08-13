package com.vti.backend.datalayer;

import com.vti.entity.Manager;
import com.vti.entity.Role;
import com.vti.utils.JdbcUtils;
import com.vti.utils.properties.MessageProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepository implements IManagerRepository {
    private MessageProperties messageProperties;
    private JdbcUtils jdbcUtils;

    public ManagerRepository() throws IOException, SQLException {
        this.messageProperties = new MessageProperties();
        jdbcUtils = JdbcUtils.getInstance();
    }

    @Override
    public List<Manager> getListManagerOfProject(String role) throws SQLException {
        Connection connection = jdbcUtils.connect();
        String sql = "SELECT pau.projectId, u.fullName, pau.Role, u.id, m.expInYear " +
                "FROM `ProjectAndUser` pau " +
                "JOIN `User` u ON u.id = pau.userId " +
                "JOIN  manager m ON m.id = u.id " +
                "WHERE pau.Role = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, role);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            List<Manager> managers = new ArrayList<>();
            // Add to managers
            do {
                Manager us = new Manager(resultSet.getInt("u.id"),
                        resultSet.getString("u.fullName"),
                        Role.valueOf(resultSet.getString("pau.Role")),
                        resultSet.getInt("m.expInYear"),
                        resultSet.getInt("pau.projectId"));
                managers.add(us);
            }
            while (resultSet.next());

            return managers;
        } else {
            throw new SQLException(messageProperties.getProperty("manager.getListManagerOfProject.cannotGetListManagerWithRole") + role);
        }
    }
}
