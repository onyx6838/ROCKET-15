package com.vti.entity;

import java.time.LocalDate;

public class Group {
    public int id;
    public String name;
    public Account creator;
    public LocalDate createDate;
    public Account[] accounts;

    public Group() {

    }

    public Group(String name, Account creator, LocalDate createDate, Account[] accounts) {
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = accounts;
    }

    public Group(String name, Account creator, LocalDate createDate, String[] usernames) {
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
        Account[] accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            accounts[i] = new Account(usernames[i]);
        }
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

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
