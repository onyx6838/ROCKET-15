package com.vti.utils;

public class MyMath {
    public static final Double PI = 3.14;

    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static float min(float a, float b) {
        return a > b ? b : a;
    }

    public static double sum(int a) {
        return a + PI;
    }

    public static int max(int a, int b) {
        return a <= b ? b : a;
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
