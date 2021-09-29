package com.vti.form;

import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class GroupFormForUpdating {
	@Length(min = 6, max = 50, groups = onCreate.class)
	@Pattern(regexp = "\\p{L}+.*\\p{L}+", message = " not contains special characters",
			groups = onUpdate.class)
	private String name;
}
