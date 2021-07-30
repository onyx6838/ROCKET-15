package com.vti.entity.ex3;

import java.util.List;

public class Employee<T> {
    private int id;
    private String name;
    private List<T> salaries;

    public Employee(int id, String name, List<T> salaries) {
        this.id = id;
        this.name = name;
        this.salaries = salaries;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaries(List<T> salaries) {
        this.salaries = salaries;
    }

    public void printInfo() {
        System.out.println("Employee{" + "id=" + id + ", name='" + name + '\'');
        System.out.println(" ----- Salaries -----");
        salaries.forEach(System.out::println);
    }

    public void printLastSalary() {
        System.out.println("Salary 12 = " + salaries.get(salaries.size() - 1));
    }
}
