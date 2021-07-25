package com.vti.frontend;

import java.util.Scanner;

public class Program2_Ques5 {
    public static void main(String[] args) {
        inputAge();
    }

    public static int inputAge() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (Integer.parseInt(input.trim()) < 0)
                    System.out.println("Wrong inputing! The age must be greater than 0, please input again");
                else return Integer.parseInt(input.trim());
            } catch (Exception e) {
                System.out.println("wrong inputing! Please input an age as int, input again");
            }
        }
    }
}
