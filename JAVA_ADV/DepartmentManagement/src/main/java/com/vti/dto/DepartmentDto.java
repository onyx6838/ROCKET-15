package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private short id;

	private String name;

	private AccountDto author;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;
}
