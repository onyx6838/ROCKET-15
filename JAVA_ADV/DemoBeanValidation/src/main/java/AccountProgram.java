package com.vti;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vti.entity.Account;

public class AccountProgram {
	public static void main(String[] args) {
		Date date  = new Date(100, 12, 20);	// 1900 + years
		Account account = new Account("account1", date);

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		// validate
		Set<ConstraintViolation<Account>> violations = validator.validate(account);
		for (ConstraintViolation<Account> violation : violations) {
			System.out.println(violation);
		}
	}
}
