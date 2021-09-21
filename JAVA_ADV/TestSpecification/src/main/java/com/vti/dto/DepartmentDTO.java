package com.vti.dto;

import com.vti.entity.Department;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DepartmentDTO {
	private String name;

	public Department toEntity() {
		return new Department(name);
	}

}
