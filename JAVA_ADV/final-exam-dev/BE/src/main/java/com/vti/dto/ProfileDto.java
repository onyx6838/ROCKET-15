package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileDto {
    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    private String role;

    private String status;

    private String avatarUrl;
}
