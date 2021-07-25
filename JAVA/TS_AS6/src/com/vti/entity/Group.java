package com.vti.entity;

import java.time.LocalDate;
import java.util.List;

public class Group {
    public int id;
    public String name;
    public Account creator;
    public LocalDate createDate;
    public List<Account> accounts;

    public Group() {

    }

    public Group(int id, String name, Account creator, LocalDate createDate, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = accounts;
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

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
