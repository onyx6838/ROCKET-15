package com.vti.backend;

import com.vti.entity.inheritance.ques2.*;
import com.vti.entity.inheritance.ques3.HighSchoolStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5_Ques2 {
    private Scanner scanner;
    private List<Officer> officerList;

    public Exercise5_Ques2() {
        scanner = new Scanner(System.in);
        officerList = new ArrayList<>();
    }

    public void Ques2() {
        menu();
    }

    private void menu() {
        while (true) {
            System.out.println("======================================================================");
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("=== 1. Thêm mới cán bộ.	===");
            System.out.println("=== 2. Tìm kiếm theo họ tên. ===");
            System.out.println("=== 3. Hiện thị thông tin về danh sách các cán bộ. ===");
            System.out.println("=== 4. Nhập vào tên của cán bộ và delete cán bộ đó ===");
            System.out.println("=== 5. Thoát khỏi chương trình. ===");
            System.out.println("======================================================================");
            int menuChoose = scanner.nextInt();
            switch (menuChoose) {
                case 1:
                    addOfficer();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    printOfficerStaff();
                    break;
                case 4:
                    deleteByName();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn đúng số trên menu");
                    break;
            }
        }
    }

    private void addOfficer() {
        System.out.println("----Lựa chọn chức năng bạn muốn sử dụng---------");
        System.out.println("--- 1. Thêm Engineer---");
        System.out.println("--- 2. Thêm Worker---");
        System.out.println("--- 3. Thêm Employeee---");
        System.out.println("------------------------------------------------");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                Officer ofiEn = readOfficerFromInput("Engineer", Engineer.class);
                officerList.add(ofiEn);
                break;
            case 2:
                Officer ofiWr = readOfficerFromInput("Worker", Worker.class);
                officerList.add(ofiWr);
                break;
            case 3:
                Officer ofiEm = readOfficerFromInput("Employee", Employee.class);
                officerList.add(ofiEm);
                break;
            default:
                break;
        }
    }

    private void findByName() {
        System.out.println("Nhập vào tên muốn tìm kiếm: ");
        String findName = scanner.next();
        for (Officer staff : officerList) {
            if (staff.getName().equals(findName)) {
                System.out.println(staff);
            }
        }
    }

    private void printOfficerStaff() {
        System.out.println("Officer List");
        for (Officer staff : officerList) {
            System.out.println(staff);
        }
    }

    private void deleteByName() {
        System.out.println("Nhập tên cần xóa thông tin: ");
        String delName = scanner.next();
        officerList.removeIf(staff -> staff.getName().equals(delName));
        printOfficerStaff();
        // hoac dung iterator link lai list
    }

    // utils scanner
    public <T> Officer readOfficerFromInput(String message, Class<T> c) {
        Officer obj = null;
        System.out.println("Nhập tên " + message + ": ");
        String name = scanner.next();
        System.out.println("Nhập tuổi " + message + ": ");
        int age = scanner.nextInt();
        System.out.println("Nhập giới tính " + message + ": 1.Male, 2.Female, 3.Unknown");
        int flagGender = scanner.nextInt();
        Gender gender = null;
        switch (flagGender) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.UNKNOWN;
                break;
        }
        scanner.nextLine();
        System.out.println("Nhập địa chỉ " + message + ": ");
        String address = scanner.nextLine();
        if (c == Employee.class) {
            System.out.println("Nhập vào nhiệm vụ Employee: ");
            String job = scanner.nextLine();
            obj = new Employee(age, name, gender, address, job);
        } else if (c == Engineer.class) {
            System.out.println("Nhập chuyên môn Engineer: ");
            String specialized = scanner.nextLine();
            obj = new Engineer(age, name, gender, address, specialized);
        } else if (c == Worker.class) {
            System.out.println("Nhập bậc Worker: ");
            int rank = scanner.nextInt();
            obj = new Worker(age, name, gender, address, rank);
        }
        return obj;
    }
}
