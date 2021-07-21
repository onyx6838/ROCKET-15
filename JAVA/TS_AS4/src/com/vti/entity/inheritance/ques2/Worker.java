package com.vti.entity.inheritance.ques2;

public class Worker extends Officer{
    private int rank;

    public Worker(int age, String name, Gender gender, String address, int rank) {
        super(age, name, gender, address);
        this.rank = rank;
    }
}
