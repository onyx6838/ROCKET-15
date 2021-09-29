package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class DetailGroupDto {
	private int id;

	private String name;

	private AccountDto creator;

	private int member;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;
}
