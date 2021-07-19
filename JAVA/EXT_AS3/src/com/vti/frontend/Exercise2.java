package com.vti.frontend;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Ques4();
    }

    private static void Ques1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string ????");
        String fullName = sc.nextLine();
        System.out.println("Normal string: " + fullName);
        System.out.println("Upper case: " + fullName.toUpperCase());
    }

    private static void Ques2() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char temp;
        int totalCharacter = 0;
        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (temp == 'a') totalCharacter++;
        }
        System.out.println("Total character 'a' in string = " + totalCharacter);
    }

    private static void Ques3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string??? ");
        String input = sc.nextLine();
        System.out.println("Character to be replace ???");
        char beRep = sc.next().charAt(0);
        System.out.println("Replace by ???");
        char byRep = sc.next().charAt(0);
        String replaced = input.replace(beRep, byRep);
        //
        System.out.println("New string after replaced: " + replaced);
    }

    private static void Ques4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string??? ");
        String input = sc.nextLine();
        // not using var ???
        System.out.print("Without var = ");
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
        // using var
        String reverseString = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverseString += input.charAt(i);
        }
        System.out.println("\nReserve String with var = " + reverseString);
    }

    private static void Ques5(){

    }
}
