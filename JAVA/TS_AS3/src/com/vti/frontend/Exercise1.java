package com.vti.frontend;

import com.vti.entity.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;

public class Exercise1 {

    public static void main(String[] args) {
        //Ques1();
        //Ques2(1000, 5);
    }

    private static void Ques1() {
        float salaryA, salaryB;
        salaryA = 5240.5f;
        salaryB = 10970.055f;


        Account account1 = new Account();
        account1.salary = salaryA;


        Account account2 = new Account();
        account2.salary = salaryB;

        int salaryIntA = (int) account1.salary;
        int salaryIntB = (int) account2.salary;
        System.out.println("A: " + salaryIntA + " B: " + salaryIntB);
    }

    public static String Ques2(int bound, int N) {
        Random random = new Random();
        int randomNum = random.nextInt(bound);
        String value = randomNum + "";
        //String value = String.valueOf(randomNum);
        while (value.length() < N)
            value += "0";
        System.out.println(value);
        return value;
    }

    public static void Ques3() {
        String num = Ques2(10000, 5);
        Integer a = Integer.valueOf(num);
        System.out.println("2 digit: " + a % 100);
    }

    public static float Ques4(int a, int b) {
        return (float) a / b;
    }
}