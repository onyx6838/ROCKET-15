package com.vti.backend;

import com.vti.entity.abstraction.Contact;
import com.vti.entity.abstraction.VietnamesePhone;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise6 {
    private Scanner scanner;

    public Exercise6() {
        scanner = new Scanner(System.in);
    }

    public void Ques1() {
        menu();
    }

    private void menu() {
        ArrayList<Contact> contacts = new ArrayList<>();
        VietnamesePhone vnesePhone = new VietnamesePhone(contacts);
        while (true) {
            System.out.println("======================================================================");
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("=== 1. InsertContact.===");
            System.out.println("=== 2. RemoveContact.===");
            System.out.println("=== 3. UpdateContact.===");
            System.out.println("=== 4. SearchContact===");
            System.out.println("=== 5. ShowContact===");
            System.out.println("=== 6. Thoát khỏi chương trình. ===");
            System.out.println("======================================================================");
            int menuChoose = scanner.nextInt();
            scanner.nextLine();
            switch (menuChoose) {
                case 1:
                    System.out.println("Nhập vào tên Contact: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập vào tên số Phone: ");
                    String phone = scanner.nextLine();
                    vnesePhone.insertContact(name, phone);
                    break;
                case 2:
                    System.out.println("Nhập vào tên Contact cần remove:");
                    String removeName = scanner.nextLine();
                    vnesePhone.removeContact(removeName);
                    break;
                case 3:
                    System.out.println("Nhập tên cần Update: ");
                    String name1 = scanner.nextLine();
                    System.out.println("Nhập số Phone mới: ");
                    String newPhone = scanner.nextLine();
                    vnesePhone.updateContact(name1, newPhone);
                    System.out.println("Kết quả: ");
                    vnesePhone.searchContact(name1);
                    break;
                case 4:
                    System.out.println("Nhập vào tên Contact cần tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    vnesePhone.searchContact(searchName);
                    break;
                case 5:
                    vnesePhone.printContactList();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Alarm: Lựa chọn đúng số trên menu");
                    break;
            }
        }
    }
}
