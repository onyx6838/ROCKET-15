package com.vti.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IJWTTokenService {
    void addJWTTokenToHeader(HttpServletResponse response, String username) throws IOException;

    Authentication parseTokenToUserInformation(HttpServletRequest request);

}
