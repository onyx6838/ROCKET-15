package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PositionTypeConverter implements AttributeConverter<PositionType, String> {
    public String convertToDatabaseColumn(PositionType name) {
        if (name == null) {
            return null;
        }
        return name.getValue();
    }

    public PositionType convertToEntityAttribute(String value) {
        return PositionType.of(value);
    }
}
