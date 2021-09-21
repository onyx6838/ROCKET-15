package com.vti.filter;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFilter {
	private int minID;
	private int maxID;
	private int minTotalMember;

}