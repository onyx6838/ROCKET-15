package com.vti.entity.abstraction.ques2;

public class Manager extends User{
    public Manager(String name, double ratio) {
        super(name, ratio);
    }

    @Override
    public double calculatePay() {
        return getRatio() * 520;
    }
}
