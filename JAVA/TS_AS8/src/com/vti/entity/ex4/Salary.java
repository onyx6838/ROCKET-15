package com.vti.entity.ex4;

public class Salary<N extends Number> {
    private N salary;

    public Salary(N salary) {
        this.salary = salary;
    }

    public N getSalary() {
        return salary;
    }

    public void setSalary(N salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.println("Salary  = " + salary);
    }
}
