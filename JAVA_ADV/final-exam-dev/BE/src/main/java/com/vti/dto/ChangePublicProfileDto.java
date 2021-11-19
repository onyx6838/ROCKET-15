package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePublicProfileDto {
    private String avatarUrl;

    private String biography;
}
