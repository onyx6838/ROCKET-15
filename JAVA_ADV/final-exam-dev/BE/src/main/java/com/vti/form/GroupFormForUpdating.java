package com.vti.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.validation.group.onUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
public class GroupFormForUpdating {
	@Length(min = 6, max = 50, groups = onUpdate.class)
	@Pattern(regexp = "\\p{L}+.*\\p{L}+", message = " not contains special characters",
			groups = onUpdate.class)
	private String name;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;

	@Min(value = 0, message = "The value must be positive")
	private int member;

}
