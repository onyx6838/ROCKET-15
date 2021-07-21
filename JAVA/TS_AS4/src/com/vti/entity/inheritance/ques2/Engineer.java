package com.vti.entity.inheritance.ques2;

public class Engineer extends Officer {
    private String specialized;

    public Engineer(int age, String name, Gender gender, String address, String specialized) {
        super(age, name, gender, address);
        this.specialized = specialized;
    }
}
