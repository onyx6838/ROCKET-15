package com.vti.frontend;

import com.vti.entity.Account;

import java.time.LocalDate;

public class Exercise6 {
    public static void main(String[] args) {
    }

    private static void Ques1() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    private static void Ques2() {
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.email = "daonq1";
        acc1.userName = "daonq1";
        acc1.fullName = "Dao Nguyen 1";
        acc1.createDate = LocalDate.now();
        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "daonq2";
        acc2.userName = "daonq2";
        acc2.fullName = "Dao Nguyen 2";
        acc2.createDate = LocalDate.of(2021, 03, 17);
        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "daonq3";
        acc3.userName = "daonq3";
        acc3.fullName = "Dao Nguyen 3";
        acc3.createDate = LocalDate.now();
        printAccount(acc1);
        printAccount(acc2);
        printAccount(acc3);
    }

    private static void printAccount(Account account) {
        System.out.println("Thông tin account");
        System.out.println("Email: " + account.email);
        System.out.println("Username: " + account.userName);
        System.out.println("fullName: " + account.fullName);
        System.out.println("CreateDate: " + account.createDate);
    }

    private static void Ques3() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }
}
