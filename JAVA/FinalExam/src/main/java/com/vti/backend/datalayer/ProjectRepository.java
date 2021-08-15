package com.vti.backend.datalayer;

import com.vti.entity.Project;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;
import com.vti.utils.properties.MessageProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements IProjectRepository {
    private MessageProperties messageProperties;
    private JdbcUtils jdbcUtils;

    public ProjectRepository() throws IOException, SQLException {
        this.messageProperties = new MessageProperties();
        jdbcUtils = JdbcUtils.getInstance();
    }

    @Override
    public Project getProjectById(int id) throws SQLException {
        Connection connection = jdbcUtils.connect();
        String sql = "SELECT pau.projectId, u.fullName, pau.Role, u.id " +
                "FROM `ProjectAndUser` pau " +
                "JOIN `User` u ON u.id = pau.userId " +
                "WHERE pau.projectId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            // Detail project
            Project project = new Project();
            List<User> users = new ArrayList<>();
            List<Integer> idEmployees = new ArrayList<>();
            // Add to project
            do {
                users.add(
                        new User(
                                resultSet.getInt("u.id"),
                                resultSet.getString("u.fullName"),
                                Role.valueOf(resultSet.getString("pau.Role"))
                        )
                );
                idEmployees.add(resultSet.getInt("u.id"));
                project.setProjectId(resultSet.getInt("pau.projectId"));
            }
            while (resultSet.next());

            project.setParticipants(users);
            project.setIdEmployees(idEmployees);
            project.setTeamSize(users.size());
            return project;
        } else {
            jdbcUtils.disconnect();
            throw new SQLException(messageProperties.getProperty("project.getProjectByID.cannotFindProjectById") + id);
        }
    }

}
