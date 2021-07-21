package com.vti.backend;

import com.vti.entity.inheritance.ques2.*;
import com.vti.entity.inheritance.ques4.Article;
import com.vti.entity.inheritance.ques4.Book;
import com.vti.entity.inheritance.ques4.Document;
import com.vti.entity.inheritance.ques4.Magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5_Ques4 {
    public static int ID = 0;
    private Scanner scanner;
    private List<Document> documentList;

    public Exercise5_Ques4() {
        scanner = new Scanner(System.in);
        documentList = new ArrayList<>();
    }

    public void Ques4() {
        menu();
    }

    private void menu() {
        while (true) {
            System.out.println("======================================================================");
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("=== 1. Thêm mới tài liệu.===");
            System.out.println("=== 2. Xóa tài liệu.===");
            System.out.println("=== 3. Hiện thị thông tin tài liệu. ===");
            System.out.println("=== 4. Tìm kiếm tài liệu theo loại ===");
            System.out.println("=== 5. Thoát khỏi chương trình. ===");
            System.out.println("======================================================================");
            int menuChoose = scanner.nextInt();
            switch (menuChoose) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    deleteDocument();
                    break;
                case 3:
                    printListDocument();
                    break;
                case 4:
                    findByCategory();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn đúng số trên menu");
                    break;
            }
        }
    }

    private void addDocument() {
        System.out.println("----------------------------------------------------");
        System.out.println("--------Lựa chọn chức năng bạn muốn sử dụng---------");
        System.out.println("--- 1. Thêm Sách---");
        System.out.println("--- 2. Thêm Báo---");
        System.out.println("--- 3. Thêm Tạp chí---");
        System.out.println("----------------------------------------------------");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                Document docBk = readDocumentFromInput("Book", Book.class);
                documentList.add(docBk);
                break;
            case 2:
                Document docArt = readDocumentFromInput("Article", Article.class);
                documentList.add(docArt);
                break;
            case 3:
                Document docMaga = readDocumentFromInput("Magazine", Magazine.class);
                documentList.add(docMaga);
                break;
            default:
                System.out.println("Đúng số");
                break;
        }
    }

    private void findByCategory() {
        System.out.println("Nhập loại tài liệu cần tìm kiếm 1.Sách, 2.Báo, 3.Tạp chí: ");
        int chooseCategory = scanner.nextInt();
        switch (chooseCategory) {
            case 1:
                documentList.stream().filter(x -> x instanceof Book).forEach(System.out::println);
                break;
            case 2:
                documentList.stream().filter(x -> x instanceof Article).forEach(System.out::println);
                break;
            case 3:
                documentList.stream().filter(x -> x instanceof Magazine).forEach(System.out::println);
                break;
            default:
                System.out.println("Tìm tử tế");
                break;
        }
    }

    private void printListDocument() {
        System.out.println("Document List");
        for (Document document : documentList) {
            System.out.println(document);
        }
    }

    private void deleteDocument() {
        System.out.println("Nhập mã tài liệu cần xoá: ");
        int idDel = scanner.nextInt();
        if (documentList.stream().anyMatch(x -> x.getId() == idDel)) {
            documentList.removeIf(doc -> doc.getId() == idDel);
            System.out.println("Xoá thành công");
        } else {
            System.out.println("Mã tài liệu bạn nhập không có trên hệ thống.");
        }

    }

    // utils scanner
    public <T> Document readDocumentFromInput(String message, Class<T> c) {
        Document obj = null;
        System.out.println("Nhập vào tên nhà xuất bản cho " + message + ": ");
        String publishingCompany = scanner.next();
        System.out.println("Nhập vào số bản phát hành cho " + message + ": ");
        int numberOfReleases = scanner.nextInt();
        ID++;
        scanner.nextLine();
        if (c == Book.class) {
            System.out.println("Nhập vào tên tác giả cho " + message + ": ");
            String author = scanner.nextLine();
            System.out.println("Nhập vào số trang cho " + message + ": ");
            int pageNumber = scanner.nextInt();
            obj = new Book(ID, publishingCompany, numberOfReleases, author, pageNumber);
        } else if (c == Article.class) {
            System.out.println("Nhập vào ngày phát hành cho " + message + ": ");
            int dayRelease = scanner.nextInt();
            obj = new Article(ID, publishingCompany, numberOfReleases, dayRelease);
        } else if (c == Magazine.class) {
            System.out.println("Nhập vào số phát hành cho " + message + ": ");
            int releaseNumber = scanner.nextInt();
            System.out.println("Nhập vào tháng phát hành cho " + message + ": ");
            int monthReleaseNumber = scanner.nextInt();
            obj = new Magazine(ID, publishingCompany, numberOfReleases, releaseNumber, monthReleaseNumber);
        }
        return obj;
    }
}
