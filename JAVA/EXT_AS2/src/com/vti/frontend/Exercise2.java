package com.vti.frontend;

import com.vti.utils.MathUtils;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //Ques123();
        //Ques5_1();
        Ques11();
    }

    // Ques 1, 2, 3
    private static void Ques123() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("n ??");
        n = sc.nextInt();
        float[] floats = new float[n];
        System.out.println("input ???\n");
        for (int i = 0; i < n; i++) {
            floats[i] = sc.nextFloat();
        }
        MathUtils.countFreq(floats, n, 1);
        MathUtils.countFreq(floats, n, 2);
        MathUtils.countFreq(floats, n, -1);
    }

    private static void Ques4() {
//        Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ.
//                Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32
        int number, digit, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        number = sc.nextInt();
        System.out.println("Sum of Digits: " + MathUtils.sumOfDigits(number));
    }

    private static void Ques5() {
//        Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố
//        Ví dụ: Số 28 được phân tích thành 2 x 2 x 7
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        number = sc.nextInt();
        MathUtils.primeFactor(number);
    }

    private static void Ques5_1() {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ::");
        number = sc.nextInt();

        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                System.out.println(i + " ");
                number = number / i;
            }
        }
        if (number > 2) {
            System.out.println(number);
        }
    }

    private static void Ques6() {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ::");
        number = sc.nextInt();
        for (int i = 2; i <= number; i++) {
            if (MathUtils.isPrime(i)) System.out.println(i + " ");
        }
    }

    private static void Ques7() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        n = sc.nextInt();
        int i = 2;
        int dem = 0;
        while (dem < n) {
            if (MathUtils.isPrime(i)) {
                System.out.println(i + " ");
                dem++;
            }
            i++;
        }
    }

    private static void Ques8() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương a = ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên dương b = ");
        int b = scanner.nextInt();
        System.out.println("USCLN của " + a + " và " + b + " là: " + MathUtils.USCLN(a, b));
        System.out.println("BSCNN của " + a + " và " + b + " là: " + MathUtils.BSCNN(a, b));
    }

    private static void Ques9() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        n = sc.nextInt();
        System.out.println("Fibonacci " + n + " = " + MathUtils.fibo(n));
    }

    private static void Ques10() {
        System.out.println("so thuan nghich 6 chu so");
        for (int i = 100000; i <= 999999; i++) {
            if (MathUtils.checkRevNum(i)) System.out.println(i + " ");
        }
    }

    // chua xong
    private static void Ques11() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        n = sc.nextInt();
        MathUtils.Permutation(1, n);
    }

    private static void Ques12() {
        int arr1[] = {0, 1, 2};
        int n1 = arr1.length;
        int arr2[] = {4, 5, 7};
        int n2 = arr2.length;
        int[] arr3 = new int[n1+n2];

        MathUtils.mergeArrays(arr1, arr2, n1, n2, arr3);

        System.out.println("Array after merging");
        for (int i=0; i < n1+n2; i++)
            System.out.print(arr3[i] + " ");
    }
}