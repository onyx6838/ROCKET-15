package com.vti.frontend;

public class Program2_Ques3 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[10]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bound");
        }
    }
}
