package com.vti.validation.form.account;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.service.IJWTTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class ResetPasswordTokenValidValidator implements ConstraintValidator<ResetPasswordTokenValid, String> {

	@Autowired
	private IJWTTokenService service;

	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {

		if (ObjectUtils.isEmpty(data)) {
			return false;
		}

		return service.isValidResetPasswordToken(data);
	}
}