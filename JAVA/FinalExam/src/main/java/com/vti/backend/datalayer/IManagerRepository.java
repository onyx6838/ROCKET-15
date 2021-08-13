package com.vti.backend.datalayer;

import com.vti.entity.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerRepository {
    List<Manager> getListManagerOfProject(String role) throws SQLException;
}
