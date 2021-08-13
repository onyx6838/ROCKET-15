package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IProjectService;
import com.vti.backend.businesslayer.ProjectService;
import com.vti.entity.Project;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectController {
    private IProjectService service;

    public ProjectController() throws SQLException, IOException {
        service = new ProjectService();
    }

    public Project getProjectById(int id) throws SQLException {
        return service.getProjectById(id);
    }
}
