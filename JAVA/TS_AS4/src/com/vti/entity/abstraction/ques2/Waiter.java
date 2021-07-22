package com.vti.entity.abstraction.ques2;

public class Waiter extends User {
    public Waiter(String name, double ratio) {
        super(name, ratio);
    }

    @Override
    public double calculatePay() {
        return getRatio() * 220;
    }
}
