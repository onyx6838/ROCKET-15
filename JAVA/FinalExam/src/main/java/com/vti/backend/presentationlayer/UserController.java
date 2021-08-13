package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class UserController {
    private IUserService service;

    public UserController() throws SQLException, IOException {
        service = new UserService();
    }

    public User login(String email, String password) throws Exception {
        return service.login(email, password);
    }
}
