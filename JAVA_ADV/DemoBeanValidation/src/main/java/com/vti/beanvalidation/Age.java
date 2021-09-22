package beanvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { AgeValidator.class })
public @interface Age {
	String message() default "The Age must be greater than 18";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min();
}