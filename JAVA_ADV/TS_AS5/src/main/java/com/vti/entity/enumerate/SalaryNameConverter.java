package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;

public class SalaryNameConverter implements AttributeConverter<SalaryName, String> {
    @Override
    public String convertToDatabaseColumn(SalaryName attribute) {
        if (attribute == null)  return null;
        return attribute.getValue();
    }

    @Override
    public SalaryName convertToEntityAttribute(String dbData) {
        return SalaryName.of(dbData);
    }
}
