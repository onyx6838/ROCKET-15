package com.vti.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class LoginInfoDto {
    private int id;
    private String fullName;
    private String role;
    private String token; // token
    private String refreshToken;
}
