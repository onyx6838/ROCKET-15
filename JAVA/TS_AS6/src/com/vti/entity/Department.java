package com.vti.entity;

public class Department {
    public int id;
    public String name;

    public Department() {

    }

    public Department(String nameDepartment) {
        this.name = nameDepartment;
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
