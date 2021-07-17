package com.vti;

import java.time.LocalDate;

public class Main {

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
        pos1.name = PositionName.Dev;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = PositionName.PM;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = PositionName.Scrum_Master;

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
        Group[] groupAcc1 = { group1, group2 };
        acc1.groups = groupAcc1;

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "daonq2";
        acc2.fullName = "Dao nguyen 2";
        acc2.userName = "daonq2";
        acc2.department = dep2;
        acc2.position = pos2;
        acc2.createDate = LocalDate.of(2021, 03, 17);
        acc2.groups = new Group[] { group3, group2 };

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "daonq3";
        acc3.fullName = "Dao nguyen 3";
        acc3.userName = "daonq3";
        acc3.department = dep3;
        acc3.position = pos3;
        acc3.createDate = LocalDate.now();

        System.out.println("Thông Tin Các Account trên hệ thống");
        System.out.println("Account 1: ID : " + acc1.id + " Email : " + acc1.email + " Username : " + acc1.userName
                + " Fullname : " + acc1.fullName + " Department: " + acc1.department.name + " Position : "
                + acc1.position.name + " Group : " + acc1.groups[0].name + " " + acc1.groups[1].name + " CreateDate : "
                + acc1.createDate);

        System.out.println("Account 2: ID : " + acc2.id + " Email : " + acc2.email + " Username : " + acc2.userName
                + " Fullname : " + acc2.fullName + " Department: " + acc2.department.name + " Position : "
                + acc2.position.name + " Group : " + acc2.groups[0].name + " " + acc2.groups[1].name + " CreateDate : "
                + acc2.createDate);

        System.out.println("Account 3: ID : " + acc3.id + " Email : " + acc3.email + " Username : " + acc3.userName
                + " Fullname : " + acc3.fullName + " Department: " + acc3.department.name + " Position : "
                + acc3.position.name + " Group : " + " CreateDate : " + acc3.createDate);
    }
}
