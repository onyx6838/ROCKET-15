package com.vti.frontend;

public class Exercise3 {
    public static void main(String[] args) {
        Ques2();
    }

    private static void Ques1() {
        Integer salary = new Integer(5000);
        System.out.printf("%.2f", salary.floatValue());
        // using format ????
    }

    private static void Ques2() {
        String s = "1234567";
        System.out.println(Integer.valueOf(s));
    }

    private static void Ques3() {
        Integer a = new Integer(1234567);
        System.out.println(a.intValue());
    }
}
