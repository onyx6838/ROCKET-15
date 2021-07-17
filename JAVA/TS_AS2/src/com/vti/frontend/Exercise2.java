package com.vti.frontend;

import com.vti.entity.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Exercise2 {
    public static void main(String[] args) {
        Ques6();
    }

    private static void Ques1() {
        int i = 5;
        System.out.printf("%d", i);
    }

    private static void Ques2() {
        int i = 100000000;
        System.out.printf(Locale.US, "%,d", i);
    }

    private static void Ques3() {
        float i = 5.567098f;
        System.out.printf("%.4f", i);
    }

    private static void Ques4() {
        /*Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
        dạng như sau:
        Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
        Tên tôi là "Nguyễn Văn A" và tôi đang độc thân*/
        String s = "Minh Giang";
        System.out.printf("Tên tôi là \"" + s + "\" và đang ổn");
    }

    private static void Ques5() {
        /*Lấy thời gian bây giờ và in ra theo định dạng sau:
        24/04/2020 11h:16p:20s*/
        String pattern = "dd/MM/yyyy hh:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        System.out.printf("Date parse " + dateFormat.format(date));
    }

    private static void Ques6() {
        /*In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
        table (giống trong Database)*/
        // create department
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Marketing";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Sale";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "BOD";

        // create position
        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = PositionName.DEV;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = PositionName.PM;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = PositionName.SCRUM_MASTER;

        // create group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing System";

        Group group2 = new Group();
        group2.id = 1;
        group2.name = "Development";

        Group group3 = new Group();
        group3.id = 1;
        group3.name = "Sale";

        // create account
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.email = "daonq1";
        acc1.fullName = "Dao nguyen 1";
        acc1.userName = "daonq1";
        acc1.department = dep1;
        acc1.position = pos1;
        acc1.createDate = LocalDate.now();
        Group[] groupAcc1 = {group1, group2};
        acc1.groups = groupAcc1;

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "daonq2";
        acc2.fullName = "Dao nguyen 2";
        acc2.userName = "daonq2";
        acc2.department = dep2;
        acc2.position = pos2;
        acc2.createDate = LocalDate.of(2021, 03, 17);
        acc2.groups = new Group[]{group3, group2};

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "daonq3";
        acc3.fullName = "Dao nguyen 3";
        acc3.userName = "daonq3";
        acc3.department = dep3;
        acc3.position = pos3;
        acc3.createDate = LocalDate.now();

        Account[] accForQues8 = new Account[]{acc1, acc2, acc3};
        printAccountTable(accForQues8);
    }

    private static void printAccountTable(Account[] accounts) {
        System.out.println("|-------------------------------------------------|");
        System.out.println("| Email\t      | Fullname\t    | DepartmentName  |");
        System.out.println("|-------------------------------------------------|");
        for (Account acc : accounts) {
            System.out.printf("|%-13s|%-17s|%-17s|\n", acc.email, acc.fullName, acc.userName);
        }
        System.out.println("|-------------------------------------------------|");
    }
}
