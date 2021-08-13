package com.vti.backend.datalayer;

import com.vti.entity.Project;

import java.sql.SQLException;

public interface IProjectRepository {
    Project getProjectById(int id) throws SQLException;
}
