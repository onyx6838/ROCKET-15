package com.vti.entity;

import java.time.LocalDate;

public class Account {
    public int id;
    public String email;
    public String userName;
    public String fullName;
    public Department department;
    public Position position;
    public LocalDate createDate;
    public Group[] groups;
    public float salary;

    public Account() {
    }

    public Account(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        Account b = (Account) o;
        if (this.id == b.id && this.fullName == b.fullName) return true;
        return false;
    }
}