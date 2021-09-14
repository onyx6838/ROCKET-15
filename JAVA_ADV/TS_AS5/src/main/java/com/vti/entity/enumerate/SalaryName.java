package com.vti.entity.enumerate;

import java.util.stream.Stream;

public enum SalaryName {
    DEV("600"), TEST("700"), ScrumMaster("1500"), PM("2000");

    private final String value;

    SalaryName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SalaryName of(String value){
        if(value == null)   return null;
        return Stream.of(SalaryName.values()).filter(x -> x.getValue().equals(value)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
