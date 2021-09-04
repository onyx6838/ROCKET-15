package com.vti.test;

import java.util.List;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();

		System.out.println("***********GET ALL EMPLOYEES***********");

		List<Employee> employees = repository.getAllEmployees();

		for (Employee em : employees) {
			System.out.println(em);
		}

	}
}