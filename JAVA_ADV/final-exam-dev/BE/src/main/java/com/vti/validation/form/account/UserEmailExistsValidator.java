package com.vti.validation.form.account;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class UserEmailExistsValidator implements ConstraintValidator<UserEmailExists, String> {

	@Autowired
	private IAccountService service;

	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {

		if (ObjectUtils.isEmpty(data)) {
			return false;
		}

		return service.existsByEmail(data);
	}
}