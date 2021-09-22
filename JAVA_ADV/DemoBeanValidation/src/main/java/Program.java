package com.vti;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vti.entity.Department;

public class Program {
	public static void main(String[] args) {
		Department department = new Department("Ph", (short) -1);

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		// validate
		Set<ConstraintViolation<Department>> violations = validator.validate(department);
		for (ConstraintViolation<Department> violation : violations) {
			System.out.println(violation);
		}
	}
}
