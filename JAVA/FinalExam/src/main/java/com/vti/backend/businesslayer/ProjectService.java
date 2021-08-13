package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IProjectRepository;
import com.vti.backend.datalayer.ProjectRepository;
import com.vti.entity.Project;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectService implements IProjectService {
    private IProjectRepository repository;

    public ProjectService() throws SQLException, IOException {
        repository = new ProjectRepository();
    }

    @Override
    public Project getProjectById(int id) throws SQLException {
        return repository.getProjectById(id);
    }
}
