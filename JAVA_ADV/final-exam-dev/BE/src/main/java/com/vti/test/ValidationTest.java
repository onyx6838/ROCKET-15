package com.vti.test;

public class ValidationTest {
    public static void main(String[] args) {
        String test = "tuấns[[[[";
        System.out.println(test.matches("\\p{L}+.*\\p{L}+"));   // utf-8 valid test
    }
}
