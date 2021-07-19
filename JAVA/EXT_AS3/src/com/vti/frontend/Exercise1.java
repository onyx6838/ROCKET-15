package com.vti.frontend;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Ques5();
    }

    private static void Ques1() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("n = ???");
        n = scanner.nextInt();
        float[] floats = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Float " + (i));
            floats[i] = scanner.nextFloat();
        }
        // Sum
        float sum = 0f;
        for (float t : floats) {
            sum += t;
        }
        System.out.println("Sum = " + sum);
        // avg
        System.out.println("Avg = " + sum / n);
        //
        float sumEvenPos = 0f;
        float sumOddPos = 0f;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) sumEvenPos += floats[i];
            else sumOddPos += floats[i];
        }
        System.out.println("Sum even = " + sumEvenPos);
        System.out.println("Sum odd = " + sumOddPos);
    }

    private static void Ques2() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("n = ???");
        n = scanner.nextInt();
        float[] floats = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Float " + (i));
            floats[i] = scanner.nextFloat();
        }
        System.out.println("x = ???");
        float x = scanner.nextFloat();
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (floats[i] == x) {
                pos = i;
                break;
            }
        }
        System.out.println("First x pos in arr floats = " + pos);
    }

    private static void Ques3() {
        Scanner scanner = new Scanner(System.in);
        int n = 16;
        int[] ints = new int[n];
        for (int i = 1; i <= n; i++) {
            System.out.println("Num (" + i + ") = ");
            ints[i] = scanner.nextInt();
        }
        System.out.println("Table");
        for (int i = 1; i <= n; i++) {
            System.out.print(ints[i] + " ");
            if (i % 4 == 0) System.out.println();
        }
    }

    private static void Ques4() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("n = ???");
        n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Float " + (i));
            ints[i] = scanner.nextInt();
        }
        // desc
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                int tmp;
                if (ints[i] > ints[j]) {
                    tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
        System.out.println("After DESC sort");
        for (int t : ints) {
            System.out.println(t + " ");
        }
        // asc
    }

    private static void Ques5() {
        //int[] ints = new int[]{10, 20, 90, 50, 100, 60, 30, 80, 70, 40};
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Num (" + i + ") = ");
            ints[i] = scanner.nextInt();
        }
        //
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                int tmp;
                if (ints[i] > ints[j]) {
                    tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
        System.out.println("After DESC sort");
        for (int t : ints) {
            System.out.println(t + " ");
        }
    }
}
