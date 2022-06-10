package com.vti.entity.enumerate;

public enum PositionType {
    DEV("Dev"), TEST("Test"), ScrumMaster("ScrumMaster"), PM("PM");

    private String value;

    PositionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PositionType of(String value) {
        if (value == null) {
            return null;
        }

        for (PositionType name : PositionType.values()) {
            if (name.getValue().equals(value)) {
                return name;
            }
        }

        return null;
    }
}
