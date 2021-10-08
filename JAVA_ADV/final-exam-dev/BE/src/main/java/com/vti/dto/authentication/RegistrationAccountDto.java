package com.vti.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationAccountDto {
    // check not null, check length , check exists, check format (regex)
    private String userName;
    // check not null, check length , check exists on database, check format (regex)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String role;
}
