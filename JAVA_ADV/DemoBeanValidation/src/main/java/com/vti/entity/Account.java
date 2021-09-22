package com.vti.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import com.vti.beanvalidation.Age;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
	private short id;

	@Size(min = 6, max = 50, message = "The name must be at least 6 character and max 50 character")
	private String name;

	@Age(min = 18)
	private Date birthDay;
}
