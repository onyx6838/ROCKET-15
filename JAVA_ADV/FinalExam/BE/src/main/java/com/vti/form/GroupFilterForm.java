package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class GroupFilterForm {
	// https://www.programmersought.com/article/85464607876/
	// https://www.baeldung.com/mysql-jdbc-timezone-spring-boot
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxDate;

}
