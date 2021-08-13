package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IManagerRepository;
import com.vti.backend.datalayer.ManagerRepository;
import com.vti.entity.Manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManagerService implements IManagerService {
    private IManagerRepository repository;

    public ManagerService() throws SQLException, IOException {
        repository = new ManagerRepository();
    }

    @Override
    public List<Manager> getListManagerOfProject(String role) throws SQLException {
        return repository.getListManagerOfProject(role);
    }
}
