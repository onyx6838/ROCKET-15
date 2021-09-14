package com.vti.test;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.repository.SalaryRepository;

public class SalaryTest {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

		System.out.println("***********GET ALL SALARYS***********");

		List<Salary> Salarys = repository.getAllSalarys();

		for (Salary Salary : Salarys) {
			System.out.println(Salary);
		}

		System.out.println("\n\n***********CREATE SALARY***********");

		Salary SalaryCreate = new Salary();
		SalaryCreate.setSalaryName(SalaryName.PM);
		repository.createSalary(SalaryCreate);

	}
}
