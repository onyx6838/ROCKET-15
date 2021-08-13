package com.vti.backend.businesslayer;

import com.vti.entity.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerService {
    List<Manager> getListManagerOfProject(String role) throws SQLException;
}
