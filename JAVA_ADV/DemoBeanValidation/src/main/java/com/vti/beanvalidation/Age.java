package com.vti.beanvalidation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { AgeValidator.class })
@Repeatable(Age.List.class)
public @interface Age {
	String message() default "The Age must be greater than {min}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min();

	@Target({ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List{
		Age[] value();
	}
}