package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class GroupDto {
    private int id;

    private String name;

    private AccountDto creator;

    private int member;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createDate;

    @Data
    @NoArgsConstructor
    static class AccountDto{
        private int id;

        private String fullName;
    }
}


