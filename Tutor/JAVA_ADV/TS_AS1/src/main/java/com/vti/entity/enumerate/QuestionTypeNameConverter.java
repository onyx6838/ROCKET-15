package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class QuestionTypeNameConverter implements AttributeConverter<QuestionTypeName, String> {
    @Override
    public String convertToDatabaseColumn(QuestionTypeName name) {
        if (name == null) {
            return null;
        }
        return name.getValue();
    }

    @Override
    public QuestionTypeName convertToEntityAttribute(String value) {
        return QuestionTypeName.of(value);
    }
}
