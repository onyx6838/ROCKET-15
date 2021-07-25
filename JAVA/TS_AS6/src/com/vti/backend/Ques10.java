package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.utils.ScannerUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ques10 {
    private List<Group> groupList;

    public Ques10() {
        groupList = new ArrayList<>();
    }

    public void menu() throws Exception {
        while (true) {
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("=== 1. Thêm mới group. ===");
            System.out.println("=== 2. View List group ===");
            System.out.println("=== 3. Thoát khỏi chương trình. ===");
            System.out.println("======================================================================");
            int menuChoose = (int) ScannerUtils.input("> 0 and true form", Integer.class);
            switch (menuChoose) {
                case 1:
                    addGroup();
                    break;
                case 2:
                    viewListGroup();
                    break;
                case 3:
                    return;
            }
        }
    }

    private void viewListGroup() {
        groupList.stream().forEach(x ->
                {
                    System.out.println(x);
                    System.out.println("Acc of group");
                    x.accounts.stream().forEach(System.out::println);
                }
        );
    }

    private void addGroup() throws Exception {
        System.out.println("Nhập id group");
        int id = (int) ScannerUtils.inputPreventPositive("> 0 and true form", Integer.class);
        System.out.println("Nhập tên group");
        String name = ScannerUtils.inputString("Cannot empty");
        LocalDate createDate = ScannerUtils.inputLocalDate("correct form");
        Account creator = null;
        List<Account> accountList = new ArrayList<>();
        System.out.println("Nhập creator (1. Có  - #. Không)");
        if (ScannerUtils.inputInt("Nhập lại") == 1) {
            creator = addAccount();
        } else return;  // out case ADD
        //
        System.out.println("Nhập các account thuộc group (1. Có  - #. Không)");
        if (ScannerUtils.inputInt("Nhập lại") == 1) {
            while (true) {
                System.out.println("Nhập account không ? (1. Có  - #. Không)");
                if (ScannerUtils.inputInt("Nhập lại") == 1) {
                    accountList.add(addAccount());
                } else break;
            }
        } else return; // out case ADD
        //
        Group group = new Group(id, name, creator, createDate, accountList);
        groupList.add(group);
    }

    private Account addAccount() throws Exception {
        int id = (int) ScannerUtils.inputPreventPositive("> 0 and true form", Integer.class);
        String email = ScannerUtils.inputString("Cannot empty");
        String userName = ScannerUtils.inputString("Cannot empty");
        String fullName = ScannerUtils.inputString("Cannot empty");
        LocalDate createDate = LocalDate.now();

        Account account = new Account(id, email, userName, fullName, createDate);
        return account;
    }
}
