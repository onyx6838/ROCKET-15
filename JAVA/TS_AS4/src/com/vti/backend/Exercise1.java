package com.vti.backend;

import com.vti.entity.*;

import java.time.LocalDate;

public class Exercise1 {
    public void Ques1() {
        Department department = new Department();
        Department department1 = new Department("Sale");
    }

    public void Ques2() {
        Account account = new Account(1, ".com", "giang.mink", "Minh", "Giang");
        Position position = new Position(1, PositionName.PM);
        Account account1 = new Account(2, ".com", "giang.mink", "Minh", "Giang", position);
        Account account2 = new Account(3, ".com", "giang.mink", "Minh", "Giang", position, LocalDate.now());
    }

    public void Ques3() {
        Group group = new Group();
        Account account = new Account(1, ".com", "giang.mink", "Minh", "Giang");
        Position position = new Position(1, PositionName.PM);
        Account account1 = new Account(2, ".com", "giang.mink", "Minh", "Giang", position);
        Account account2 = new Account(3, ".com", "giang.mink", "Minh", "Giang", position, LocalDate.now());
        Account[] accounts = new Account[]{account1, account2, account};
        Group group1 = new Group("Gr1", account, LocalDate.now(), accounts);
        String[] usernames = new String[]{"minkgiang", "mg", "gg"};
        Group group2 = new Group("Gr2", account, LocalDate.now(), usernames);

        for (Account acc :
                group2.accounts) {
            System.out.println(acc.getUserName());
        }
    }
}