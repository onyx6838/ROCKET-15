package com.vti.backend.datalayer;

import com.vti.entity.User;

public interface IUserRepository {
    User login(String email, String password) throws Exception;
}
