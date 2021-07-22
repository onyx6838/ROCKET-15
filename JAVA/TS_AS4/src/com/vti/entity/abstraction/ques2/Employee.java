package com.vti.entity.abstraction.ques2;

public class Employee extends User {
    public Employee(String name, double ratio) {
        super(name, ratio);
    }

    @Override
    public double calculatePay() {
        return getRatio() * 420;
    }
}
