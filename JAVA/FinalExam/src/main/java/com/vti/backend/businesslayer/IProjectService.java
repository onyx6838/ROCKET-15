package com.vti.backend.businesslayer;

import com.vti.entity.Project;

import java.sql.SQLException;

public interface IProjectService {
    Project getProjectById(int id) throws SQLException;
}
