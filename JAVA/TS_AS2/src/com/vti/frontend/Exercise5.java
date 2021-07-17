package com.vti.frontend;

import com.vti.entity.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
       /* Ques1();
        Ques2();
        Ques3();
        Ques4();*/
        Ques10();
    }

    private static void Ques1() {
        //Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 3 số nguyên");
        System.out.println("Nhập vào số 1: ");
        int a = scanner.nextInt();
        System.out.println("Nhập vào số 2: ");
        int b = scanner.nextInt();
        System.out.println("Nhập vào số 3: ");
        int c = scanner.nextInt();
        System.out.println("Bạn vừa nhập vào các số: " + a + " " + b + " " + c);
    }

    private static void Ques2() {
        //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào 2 số thực");
        System.out.println("Nhập vào số 1: ");
        float f1 = sc.nextFloat();
        System.out.println("Nhập vào số 2: ");
        float f2 = sc.nextFloat();
        System.out.println("Bạn vừa nhập vào các số: " + f1 + " " + f2);
    }

    private static void Ques3() {
        //Viết lệnh cho phép người dùng nhập họ và tên
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào Họ: ");
        String s1 = sc.next();
        System.out.println("Mời bạn nhập vào Tên: ");
        String s2 = sc.next();
        System.out.println("Fullname của bạn là:" + s1 + " " + s2);
    }

    private static void Ques4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào năm sinh: ");
        int year = sc.nextInt();
        System.out.println("Mời bạn nhập vào tháng sinh: ");
        int month = sc.nextInt();
        System.out.println("Mời bạn nhập vào ngày sinh: ");
        int day = sc.nextInt();
        LocalDate dateBirth = LocalDate.of(year, month, day);
        System.out.println("Ngày sinh của bạn là: " + dateBirth);
    }

    private static void Ques5() {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Nhập ID: ");
        account.id = sc.nextInt();  // k xuong dong
        System.out.println("Nhập email: ");
        account.email = sc.next();
        System.out.println("Nhập userName: ");
        account.userName = sc.next();
        System.out.println("Nhập fullName: ");
        account.fullName = sc.next();
        sc.nextLine();
        System.out.println("Mời bạn nhập vào vị trí: ");
        int position = sc.nextInt();
        Position pos = new Position();
        switch (position) {
            case 1:
                account.position = pos;
                break;
            case 2:
                pos.name = PositionName.TEST;
                account.position = pos;
                break;
            case 3:
                pos.name = PositionName.SCRUM_MASTER;
                account.position = pos;
                break;
            case 4:
                pos.name = PositionName.PM;
                account.position = pos;
                break;
        }
        System.out.println("Thông tin account");
        System.out.println("Id " + account.id);
        System.out.println("Fullname " + account.fullName);
        System.out.println("Email " + account.email);
        System.out.println("Username " + account.userName);
        System.out.println("Position " + account.position.name);
    }

    private static void Ques6() {
        // Viết lệnh cho phép người dùng tạo department (viết thành method)
        System.out.println("Nhập thông tin department");
        Scanner sc = new Scanner(System.in);
        Department department = new Department();
        System.out.println("Mời bạn nhập vào Id: ");
        department.id = sc.nextInt();
        System.out.println("Mời bạn nhập vào tên phòng ban: ");
        department.name = sc.next();
        System.out.println("Department vừa nhập: ");
        System.out.println("Id: " + department.id);
        System.out.println("Name: " + department.name);
    }

    private static void Ques7() {
        // Nhập số chẵn từ console
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập số chẵn");
            if (sc.nextInt() % 2 == 0) {
                System.out.println("Bạn vừa nhập số chẵn : " + sc.nextInt());
            } else {
                System.out.println("Đây k phải số chẵn. Nhập lại");
            }
        }
    }

    private static void Ques8() {
        Scanner sc = new Scanner(System.in);
        int function;

        while (true) {
            System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
            function = sc.nextInt();
            // co the return de end chuong trinh neu chon 1 hoac 2 ??? k can thì break
            switch (function) {
                case 1:
                    Ques5();
                    break;
                case 2:
                    Ques6();
                    break;

                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }
    }

    private static void Ques9() {
        Scanner sc = new Scanner(System.in);
        // Tạo Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing_System";
        group1.createDate = LocalDate.of(2021, 1, 1);
        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        group2.createDate = LocalDate.of(2020, 2, 1);
        Group group3 = new Group();
        group3.id = 3;
        group3.name = "Sale";
        group3.createDate = LocalDate.of(2019, 9, 23);
        // Tạo Account
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
        Account[] accounts = {acc1, acc2, acc3};
        Group[] groups = {group1, group2, group3};
        // B1
        System.out.println("username của người dùng");
        for (Account acc :
                accounts) {
            System.out.println("Username của " + acc.fullName + " là " + acc.userName);
        }
        // B2
        System.out.println("Nhập username của account");
        String userName = sc.nextLine();

        // B3
        System.out.println("Tên các group");
        for (Group g :
                groups) {
            System.out.println("Group " + g.name);
        }

        // B4
        System.out.println("Nhập tên của group");
        String groupName = sc.nextLine();

        // B5
        int indexFindAccount = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].userName.equals(userName)) {
                indexFindAccount = i;
            }
        }

        int indexFindGroup = -1;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].name.equals(groupName)) {
                indexFindGroup = i;
            }
        }
        // ??
        if (indexFindAccount == -1 || indexFindGroup == -1) {
            System.out.println("Check account hoặc group nhập vào");
        } else {
            groups[indexFindGroup].accounts = new Account[]{accounts[indexFindAccount]};
        }
    }

    private static void Ques10() {
        Scanner sc = new Scanner(System.in);
        int function;

        while (true) {
            System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
            System.out.println("1. Thêm account mới");
            System.out.println("2. Thêm department mới");
            System.out.println("3. Thêm account vào group");
            //System.out.println("0. Thoát chương trình");

            function = sc.nextInt();
            if (function == 1 || function == 2 || function == 3) {
                switch (function) {
                    case 1:
                        Ques5();
                        break;
                    case 2:
                        Ques6();
                        break;
                    case 3:
                        Ques9();
                        break;
                }
                int rechoose;
                System.out.println("Tiếp tục ? 0. Không \n1. Tiếp tục");
                rechoose = sc.nextInt();
                if (rechoose == 0) return;
            } else System.out.println("Nhập lại");
        }
    }

    private static void Ques11() {
        Scanner sc = new Scanner(System.in);
        int function;

        while (true) {
            System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
            System.out.println("1. Thêm account mới");
            System.out.println("2. Thêm department mới");
            System.out.println("3. Thêm account vào group");
            System.out.println("4. Thêm account vào random group");
            function = sc.nextInt();
            switch (function) {
                case 1:
                    System.out.println("F1");
                    break;
                case 2:
                    System.out.println("F2");
                    break;
                case 3:
                    System.out.println("F3");
                    break;
                case 4:
                    addAccountToRandomGroup();
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
            if (function > 0 && function <= 4) {
                System.out.println("Continue ??");
                if (sc.nextInt() == 0) return;
            }
        }
    }

    private static void addAccountToRandomGroup() {
        Scanner sc = new Scanner(System.in);
        // Tạo Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing_System";
        group1.createDate = LocalDate.of(2021, 1, 1);
        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        group2.createDate = LocalDate.of(2020, 2, 1);
        Group group3 = new Group();
        group3.id = 3;
        group3.name = "Sale";
        group3.createDate = LocalDate.of(2019, 9, 23);
        // Tạo Account
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
        Account[] accounts = {acc1, acc2, acc3};
        Group[] groups = {group1, group2, group3};
        // b1
        System.out.println("Danh sách User đang có trên hệ thống: ");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].userName);
        }
        // b2
        System.out.println("Nhập vào UserName của account: ");
        String userName = sc.nextLine();

        // b3
        Random random = new Random();
        int randomIndexGroup = random.nextInt(groups.length);
        int indexAccount = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].userName.equals(userName)) {
                indexAccount = i;
            }
        }
        if (indexAccount == -1) {
            System.out.println("ktra account vừa nhập");
        } else {
            groups[randomIndexGroup].accounts = new Account[]{accounts[indexAccount]};
        }
    }
}
