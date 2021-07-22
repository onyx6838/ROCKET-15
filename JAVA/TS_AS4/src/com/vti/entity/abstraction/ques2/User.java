package com.vti.entity.abstraction.ques2;

public abstract class User {
    private String name;
    private double ratio;

    public abstract double calculatePay();

    public void displayInfor() {
        System.out.println("Name: " + name);
        System.out.println("Ratio: " + ratio);
        System.out.println("Salary: " + calculatePay());
    }

    public User(String name, double ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public double getRatio() {
        return ratio;
    }
}
