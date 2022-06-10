package com.vti.entity.enumerate;

public enum QuestionTypeName {
    ESSAY("Essay"), MULTIPLE_CHOICE("Multiple-Choice");

    private String value;

    QuestionTypeName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static QuestionTypeName of(String value) {
        if (value == null) {
            return null;
        }

        for (QuestionTypeName name : QuestionTypeName.values()) {
            if (name.getValue().equals(value)) {
                return name;
            }
        }

        return null;
    }
}
