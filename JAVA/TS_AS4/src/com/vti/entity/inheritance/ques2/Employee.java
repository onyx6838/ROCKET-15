package com.vti.entity.inheritance.ques2;

public class Employee extends Officer {
    private String job;

    public Employee(int age, String name, Gender gender, String address, String job) {
        super(age, name, gender, address);
        this.job = job;
    }
}
