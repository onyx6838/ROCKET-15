package com.vti.entity.impl.ex1;

import com.vti.entity.ex1.ITuyenSinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
    private Scanner scanner;
    private List<Contestant> contestantList;

    public TuyenSinh() {
        scanner = new Scanner(System.in);
        contestantList = new ArrayList<>();
    }

    public void menu() {
        while (true) {
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
            System.out.println("=== 1. Insert contestant.===");
            System.out.println("=== 2. View list contestant.===");
            System.out.println("=== 3. Find contestant by id .===");
            System.out.println("=== 4. Exit.===");
            System.out.println("=======================================================================");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addContestant();
                    break;
                case 2:
                    viewListContestant();
                    break;
                case 3:
                    System.out.println("Nhap id can tim");
                    int idFind = scanner.nextInt();
                    findContestantById(idFind);
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    @Override
    public void addContestant() {
        scanner.nextLine();
        System.out.println("Nhập vào tên thí sinh:");
        String name = scanner.nextLine();
        System.out.println("Nhập vào địa chỉ thí sinh:");
        String address = scanner.nextLine();
        System.out.println("Nhập vào mức ưu tiên thí sinh:");
        int priority = scanner.nextInt();
        System.out.println("Nhập vào khối thí sinh chọn các khối A, B, C:");
        String block = scanner.next();
        Contestant contestant = new Contestant(name, address, priority, new Block(block));
        contestantList.add(contestant);
    }

    @Override
    public void viewListContestant() {
        contestantList.stream().forEach(System.out::println);
    }

    @Override
    public void findContestantById(int id) {
        contestantList.stream().filter(x -> x.getId() == id).forEach(System.out::println);
    }
}
