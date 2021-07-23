package com.vti.backend;

import com.vti.entity.impl.ex1.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyNews {
    private Scanner scanner;
    private List<News> newsList;

    public MyNews() {
        scanner = new Scanner(System.in);
        newsList = new ArrayList<>();
    }

    public void menu() {
        while (true) {
            System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
            System.out.println("=== 1. Insert news.===");
            System.out.println("=== 2. View list news.===");
            System.out.println("=== 3. Average rate .===");
            System.out.println("=== 4. Exit.===");
            System.out.println("=======================================================================");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    int[] rates = new int[3];
                    System.out.println("Nhập vào Title");
                    String title = scanner.next();
                    System.out.println("Nhập vào PublishDate");
                    String publishDate = scanner.next();
                    System.out.println("Nhập vào Author");
                    String author = scanner.next();
                    System.out.println("Nhập vào Content");
                    String content = scanner.next();
                    System.out.println("Nhập vào đánh giá 1");
                    rates[0] = scanner.nextInt();
                    System.out.println("Nhập vào đánh giá 2");
                    rates[1] = scanner.nextInt();
                    System.out.println("Nhập vào đánh giá 3");
                    rates[2] = scanner.nextInt();
                    News news = new News(title, publishDate, author, content, rates);
                    newsList.add(news);
                    break;
                case 2:
                    System.out.println("View list news");
                    newsList.stream().forEach(x -> x.Display());
                    break;
                case 3:
                    for (News nw : newsList) nw.Calculate();
                    newsList.stream().forEach(x -> x.Display());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Again ?");
                    break;
            }
        }
    }
}
