package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IManagerService;
import com.vti.backend.businesslayer.ManagerService;
import com.vti.entity.Manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManagerController {
    private IManagerService service;

    public ManagerController() throws SQLException, IOException {
        service = new ManagerService();
    }

    public List<Manager> getListManagerOfProject(String role) throws SQLException {
        return service.getListManagerOfProject(role);
    }
}
