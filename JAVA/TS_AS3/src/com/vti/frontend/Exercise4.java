package com.vti.frontend;

import com.vti.entity.Account;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise4 {
    public static void main(String[] args) {
        //Ques1();
        //Ques16(" do van hai ", 3);
        //Ques10("down", "nwod");
        //System.out.println(Ques13("123d") ? "contain number" : "no contain number");
        Ques14("VTI academyeee    eaEEE");
    }

    public static void Ques1() {
        String in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ??? ");
        in = scanner.nextLine();
        in = in.trim().replaceAll("\\s+", "");
        System.out.println("So Ki Tu " + in.length());
    }

    public static void Ques2() {
        String in1, in2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input1 ??? ");
        in1 = scanner.nextLine();
        System.out.println("Input2 ??? ");
        in2 = scanner.nextLine();
        System.out.println(in1 + in2);
    }

    /**
     * Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
     * viết hoa chữ cái đầu thì viết hoa lên
     */
    public static void Ques3() {
        String in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ??? ");
        in = scanner.nextLine();
        String[] arrayWord = in.trim().split("\\s+");
        for (int i = 0; i < arrayWord.length; i++) {
            arrayWord[i] = arrayWord[i].substring(0, 1).toUpperCase() + arrayWord[i].substring(1).toLowerCase();
        }
        String rs = String.join(" ", arrayWord);
        System.out.println(rs);
        scanner.close();
    }

    public static void Ques4() {
        String in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ??? ");
        in = scanner.nextLine();
        in = in.toUpperCase();
        for (int i = 0; i < in.length(); i++) {
            System.out.println("Ki tu thu " + (i + 1) + " " + in.charAt(i));
        }
    }

    public static void Ques5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ: ");
        String firstName = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String lastName = scanner.nextLine();
        System.out.println("Họ tên đầy đủ: " + firstName.concat(lastName));
        scanner.close();
    }

    public static void Ques6() {
        String in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ??? ");
        in = scanner.nextLine();
        String[] arrayWord = in.trim().split("\\s+");
        for (int i = 0; i < arrayWord.length; i++) {
            arrayWord[i] = arrayWord[i].substring(0, 1).toUpperCase() + arrayWord[i].substring(1).toLowerCase();
        }
        System.out.println("Ho " + arrayWord[0]);
        System.out.println("Dem " + arrayWord[1]);
        System.out.println("Ten " + arrayWord[2]);
        // name 4 word wrong ???? [2] ,[3]
    }

    public static void Ques7() {
        String in;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ??? ");
        in = scanner.nextLine();
        String[] arrayWord = in.trim().split("\\s+");   // a??
        for (int i = 0; i < arrayWord.length; i++) {
            arrayWord[i] = arrayWord[i].substring(0, 1).toUpperCase() + arrayWord[i].substring(1).toLowerCase();
        }
        String rs = String.join(" ", arrayWord);  // b rs???
        System.out.println(rs);
        scanner.close();
    }

    public static void Ques8() {
        String[] groupNames = {"Java with VTI", "Cách qua môn gia va", "Học Java có khó không?"};
        for (String groupName : groupNames) {
            if (groupName.contains("Java")) {   // contain search
                System.out.println(groupName);
            }
        }
    }

    public static void Ques9() {
        String[] groupNames = {"Java", "C# and JAVA", "C++ and jAvA"};
        for (String groupName : groupNames) {
            if (groupName.equals("Java")) { // equal search
                System.out.println(groupName);
            }
        }
    }

    public static void Ques10(String check, String pad) {
        String rev = "";
        for (int i = check.length() - 1; i >= 0; i--) {
            rev = rev + check.charAt(i);
        }
        System.out.println(rev.equalsIgnoreCase(pad) ? "Palindrome" : "Not Palindrome)");
    }

    private static void Ques11(String input) {
        // JAVA 8 stream
        long count = input.chars().filter(x -> x == 'a').count();
        System.out.println("Freq a = " + count);
        // compare ??
        int countCom = 0;
        for (int i = 0; i < input.length(); i++) {
            if ('a' == input.charAt(i)) {
                countCom++;
            }
        }
        System.out.println("Freq a com = " + countCom);
    }

    private static void Ques12(String check) {
        String rev = "";
        for (int i = check.length() - 1; i >= 0; i--) {
            rev = rev + check.charAt(i);
        }
        System.out.println("Rev string : " + rev);
    }

    public static boolean Ques13(String check) {
        return null == check ? false : (check.matches(".*\\d.*") ? true : false);
    }

    public static void Ques14(String input) {   // regex ??
        String rs = input.replaceAll("[eE]", "*");
        System.out.println("Replace string: " + rs);
    }

    public static void Ques15(String input) {
        String[] arrayWord = input.trim().split("\\s+");   // a??
        for (int i = arrayWord.length - 1; i >= 0; i--) {
            System.out.print(arrayWord[i] + " ");
        }
    }

    public static void Ques16(String input, int n) {
        if (input.length() % n != 0 || input.isEmpty() || input == null) {
            System.out.println("KO");
            return;
        }
        String reg = "(?<=\\G.{" + n + "})";    // new line prob ????
        String[] digits = input.split(reg);
        for (String s : digits) System.out.println(s);
    }

}
