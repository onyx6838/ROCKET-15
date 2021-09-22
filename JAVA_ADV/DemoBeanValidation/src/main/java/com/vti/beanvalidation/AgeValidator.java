package beanvalidation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Date> {

	protected int min;

	@Override
	public void initialize(Age age) {
		ConstraintValidator.super.initialize(age);
		min = age.min();
	}

	@Override
	public boolean isValid(Date birthDay, ConstraintValidatorContext context) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1 * min);
		Date dateBefore18Years = cal.getTime();
		System.out.println(dateBefore18Years);
		return !birthDay.before(dateBefore18Years);
	}

}
