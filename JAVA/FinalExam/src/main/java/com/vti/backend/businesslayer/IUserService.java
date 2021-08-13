package com.vti.backend.businesslayer;

import com.vti.entity.User;

public interface IUserService {
    User login(String email, String password) throws Exception;
}
