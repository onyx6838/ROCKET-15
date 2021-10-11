package com.vti.validation.form.group;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateRange {

    String message() default "Start date must be before end date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
