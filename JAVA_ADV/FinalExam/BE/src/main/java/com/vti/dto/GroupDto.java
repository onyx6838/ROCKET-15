package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private int id;

    private String name;

    private AccountDto creator;

    private int member;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createDate;
}
