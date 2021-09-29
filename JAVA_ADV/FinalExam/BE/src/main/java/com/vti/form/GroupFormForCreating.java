package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFormForCreating {

	private String name;

	private int authorId; // chua co login k co ten de hien thi len FE

}
