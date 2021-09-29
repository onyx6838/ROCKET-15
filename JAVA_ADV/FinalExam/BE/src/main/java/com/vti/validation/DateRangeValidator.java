package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, DateRangeComplex> {
    @Override
    public boolean isValid(DateRangeComplex value, ConstraintValidatorContext context) {
        return value.getStartOfRange().before(value.getEndOfRange());
    }
}
