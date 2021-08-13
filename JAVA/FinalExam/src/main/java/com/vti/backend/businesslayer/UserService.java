package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class UserService implements IUserService {
    private IUserRepository repository;

    public UserService() throws SQLException, IOException {
        repository = new UserRepository();
    }

    @Override
    public User login(String email, String password) throws Exception {
        return repository.login(email, password);
    }
}
