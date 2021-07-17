package com.vti.frontend;

import com.vti.entity.*;

import java.time.LocalDate;

public class Exercise1 {
    public static void main(String[] args) {
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
        //------------------------------------------ IF
        // Ques 1
        Ques1(acc2);

        // Ques2
        Ques2(acc2);

        // Ques3
        Ques3(acc2);

        // Ques4
        Ques4(acc1);

        //------------------------------------------ SWITCH CASE
        // Ques5
        group1.accounts = new Account[]{acc1, acc2};
        Ques5(group1);

        // Ques6
        Ques6(acc2);

        // Ques7
        Ques7(acc1);

        //------------------------------------------ FOR EACH
        // Ques8
        Account[] accForQues8 = new Account[]{acc1, acc2, acc3};

        Ques8(accForQues8);

        // Ques9
        Department[] dptForQues9 = new Department[]{dep1, dep2, dep3};

        Ques9(dptForQues9);

        //------------------------------------------ FOR
        // Ques 10
        // change Data
        acc1.email = "NguyenVanA@gmail.com";
        acc1.fullName = "Nguyễn Văn A";
        acc1.department.name = "Sale";

        acc2.email = "NguyenVanB@gmail.com";
        acc2.fullName = "Nguyễn Văn B";
        acc2.department.name = "Marketting";

        Account[] accForQues10 = new Account[]{acc1, acc2};
        Ques10(accForQues10);

        // Ques 11
        Department[] depForQues11 = new Department[]{dep1, dep2, dep3};
        Ques11(depForQues11);

        // Ques 12
        Department[] depForQues12 = new Department[]{dep1, dep2};
        Ques12(depForQues12);

        // Ques 13
        Account[] accForQues13 = new Account[]{acc1, acc2};
        Ques13(accForQues13);

        // Ques 14
        Account[] accForQues14 = new Account[]{acc1, acc2};
        Ques14(accForQues14);

        // Ques 15
        Ques15();

        //------------------------------------------ WHILE
        // Ques 16 - 1
        Ques16_1(accForQues10);

        // Ques 16 - 2
        Ques16_2(depForQues11);

        // Ques 16 - 3
        Ques16_3(depForQues12);

        // Ques 16 - 4
        Ques16_4(accForQues13);

        // Ques 16 - 5
        Ques16_5(accForQues14);

        // Ques 16 - 6
        Ques16_6();

        //------------------------------------------ DO WHILE
        // Ques 17 - 1
        Ques17_1(accForQues10);

        // Ques 17 - 2
        Ques17_2(depForQues11);

        // Ques 17 - 3
        Ques17_3(depForQues12);

        // Ques 17 - 4
        Ques17_4(accForQues13);

        // Ques 17 - 5
        Ques17_5(accForQues14);

        // Ques 17 - 6
        Ques17_6();

    }


    private static void Ques1(Account account) {
        System.out.println("\nKiểm tra account thứ 2");
        if (account.department.name == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account.department.name);
        }
    }

    private static void Ques2(Account account) {
        if (account.groups.length == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (account.groups.length == 1 || account.groups.length == 2) {
            System.out.println("Group của nhân viên này thuộc là Java Fresher, C# Fresher");
        } else if (account.groups.length == 3) {
            System.out.println("Nhân viên này là người quan trọng");
        } else {
            System.out.println("Nvien này ...");
        }
    }

    private static void Ques3(Account account) {
        System.out.println(account.department.name == null ? "Nhân viên này chưa có phòng ban" :
                "Phòng ban của nhân viên này là " + account.department.name);
    }

    private static void Ques4(Account account) {
        System.out.println(account.position.name == PositionName.DEV ? "Đây là developer" : "người này k phải developer");
    }

    private static void Ques5(Group group) {
        int totalMemberQues5 = group.accounts.length;
        switch (totalMemberQues5) {
            case 1:
                System.out.println("Nhóm có 1 thành viên");
                break;
            case 2:
                System.out.println("Nhóm có 2 thành viên");
                break;
            case 3:
                System.out.println("Nhóm có 3 thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }
    }

    private static void Ques6(Account account) {
        int totalGroupQues6 = account.groups.length;
        switch (totalGroupQues6) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này thuộc là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng");
                break;
            default:
                System.out.println("Nvien này ...");
                break;
        }
    }

    private static void Ques7(Account account) {
        switch (account.position.name) {
            case DEV:
                System.out.println("Đây là developer");
                break;
            default:
                System.out.println("người này k phải developer");
                break;
        }
    }

    private static void Ques8(Account[] accounts) {
        for (Account acc : accounts) {
            System.out.println("Email: " + acc.email);
            System.out.println("\nFullName: " + acc.fullName);
            System.out.println("\nDepartmentName: " + acc.department.name);
        }
    }

    private static void Ques9(Department[] departments) {
        for (Department dpt :
                departments) {
            System.out.println("Id: " + dpt.id);
            System.out.println("\nName: " + dpt.name);
        }
    }

    private static void Ques10(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("\nEmail " + accounts[i].email);
            System.out.println("\nFullname " + accounts[i].fullName);
            System.out.println("\nDepartment " + accounts[i].department.name);
        }
    }

    private static void Ques11(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department " + (i + 1) + " là:");
            System.out.println("\nId " + departments[i].id);
            System.out.println("\nName " + departments[i].name);
        }
    }

    private static void Ques12(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department " + (i + 1) + " là:");
            System.out.println("\nId: " + departments[i].id);
            System.out.println("\nName: " + departments[i].name);
        }
    }

    private static void Ques13(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (i != 1) {
                System.out.println("Thông tin account thứ " + (i + 1));
                System.out.println("\nEmail " + accounts[i].email);
                System.out.println("\nFullname " + accounts[i].fullName);
                System.out.println("\nDepartment " + accounts[i].department.name);
            }
        }
    }

    private static void Ques14(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].id < 4) {
                System.out.println("Thông tin account thứ " + (i + 1));
                System.out.println("\nEmail " + accounts[i].email);
                System.out.println("\nFullname " + accounts[i].fullName);
                System.out.println("\nDepartment " + accounts[i].department.name);
            }
        }
    }

    private static void Ques15() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) System.out.println("So chan " + i);
        }
    }

    private static void Ques16_1(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("\nEmail " + accounts[i].email);
            System.out.println("\nFullname " + accounts[i].fullName);
            System.out.println("\nDepartment " + accounts[i].department.name);
        }
    }

    private static void Ques16_2(Department[] departments) {
        int i = 0;
        while (i < departments.length) {
            System.out.println("Thông tin department " + (i + 1) + " là:");
            System.out.println("\nId " + departments[i].id);
            System.out.println("\nName " + departments[i].name);
        }
    }

    private static void Ques16_3(Department[] departments) {
        int i = 0;
        while (i < departments.length) {
            System.out.println("Thông tin department " + (i + 1) + " là:");
            System.out.println("\nId: " + departments[i].id);
            System.out.println("\nName: " + departments[i].name);
        }
    }

    private static void Ques16_4(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            if (i != 1) {
                System.out.println("Thông tin account thứ " + (i + 1));
                System.out.println("\nEmail " + accounts[i].email);
                System.out.println("\nFullname " + accounts[i].fullName);
                System.out.println("\nDepartment " + accounts[i].department.name);
            }
        }
    }

    private static void Ques16_5(Account[] accounts) {
        int i = 0;
        while (i < accounts.length) {
            if (accounts[i].id < 4) {
                System.out.println("Thông tin account thứ " + (i + 1));
                System.out.println("\nEmail " + accounts[i].email);
                System.out.println("\nFullname " + accounts[i].fullName);
                System.out.println("\nDepartment " + accounts[i].department.name);
            }
        }
    }

    private static void Ques16_6() {
        int i = 0;
        while (i <= 20) {
            if (i % 2 == 0) System.out.println("So chan " + i);
        }
    }

    private static void Ques17_1(Account[] accounts) {
        int i = 0;
        do {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("\nEmail " + accounts[i].email);
            System.out.println("\nFullname " + accounts[i].fullName);
            System.out.println("\nDepartment " + accounts[i].department.name);
        }
        while (i < accounts.length);
    }

    private static void Ques17_2(Department[] departments) {
        int i = 0;
        do {
            System.out.println("Thông tin department " + (i + 1) + " là:");
            System.out.println("\nId " + departments[i].id);
            System.out.println("\nName " + departments[i].name);
        }
        while (i < departments.length);
    }

    private static void Ques17_3(Department[] departments) {
        int i = 0;
        do {
            System.out.println("Thông tin department " + (i + 1) + " là:");
            System.out.println("\nId: " + departments[i].id);
            System.out.println("\nName: " + departments[i].name);
        }
        while (i < departments.length);
    }

    private static void Ques17_4(Account[] accounts) {
        int i = 0;
        do {
            if (i != 1) {
                System.out.println("Thông tin account thứ " + (i + 1));
                System.out.println("\nEmail " + accounts[i].email);
                System.out.println("\nFullname " + accounts[i].fullName);
                System.out.println("\nDepartment " + accounts[i].department.name);
            }
        }
        while (i < accounts.length);
    }

    private static void Ques17_5(Account[] accounts) {
        int i = 0;
        do {
            if (accounts[i].id < 4) {
                System.out.println("Thông tin account thứ " + (i + 1));
                System.out.println("\nEmail " + accounts[i].email);
                System.out.println("\nFullname " + accounts[i].fullName);
                System.out.println("\nDepartment " + accounts[i].department.name);
            }
        }
        while (i < accounts.length);
    }

    private static void Ques17_6() {
        int i = 0;
        do {
            if (i % 2 == 0) System.out.println("So chan " + i);
        }
        while (i <= 20);
    }
}