package com.vti.frontend;

import com.vti.entity.Account;

import java.time.LocalDate;

public class Exercise2 {
    public static void main(String[] args) {
        Ques1();
    }

    public static void Ques1() {
        Account[] accounts = new Account[5];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].email = "Email " + (i + 1);
            accounts[i].userName = "User name " + (i + 1);
            accounts[i].fullName = "Full name " + (i + 1);
            accounts[i].createDate = LocalDate.now();
        }
        System.out.println("------------------------");
        for (Account acc : accounts) {
            System.out.println(acc.email);
        }
    }
}
