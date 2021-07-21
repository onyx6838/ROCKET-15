package com.vti.entity.inheritance.ques2;

public class Officer {
    private int age;
    private String name;
    private Gender gender;
    private String address;

    public Officer() {

    }

    public Officer(int age, String name, Gender gender, String address) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
