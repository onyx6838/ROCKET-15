package com.vti.entity.enumerate;

import java.util.stream.Stream;

public enum PositionName {
    DEV("Dev"), TEST("Test"), ScrumMaster("ScrumMaster"), PM("PM");

    private String value;

    PositionName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static PositionName of(String value) {
        if (value == null) {
            return null;
        }
        return Enum.valueOf(PositionName.class, value);
        //return Stream.of(PositionName.values()).filter(x -> x.getValue().equals(value)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
