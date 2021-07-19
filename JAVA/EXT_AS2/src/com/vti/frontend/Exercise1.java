package com.vti.frontend;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Ques6();
    }

    private static void Ques1() {
        Scanner scanner = new Scanner(System.in);
        float cm;
        System.out.println("cm = ???");
        cm = scanner.nextFloat();
        double inch = cm * 1 / 2.54;
        System.out.printf("cm to inch = %.2f", inch);
        double foot = cm * 1 / 12;
        System.out.printf("\ncm to foot = %.2f", foot);
    }

    private static void Ques2() {
        Scanner scanner = new Scanner(System.in);
        int totalSecs;

        while (true) {
            System.out.println("Time ??");
            totalSecs = scanner.nextInt();
            if (totalSecs >= 0 && totalSecs <= 68399) {
                // without array
                int hours, minutes, seconds;
                hours = totalSecs / 3600;
                minutes = (totalSecs % 3600) / 60;
                seconds = totalSecs % 60;
                System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
//                int[] times = {hours,minutes,seconds};
//                System.out.println("Time converted:   ");
//                for (int i = 0; i < times.length; i++) {
//                    System.out.print(i == times.length - 1 ? times[i] : times[i] + ":");
//                }
                return;
            } else {
                System.out.println("???");
            }
        }
    }

    private static void Ques3() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("n = ?");
        n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
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
        System.out.println("Max ele = " + ints[n - 1]);
        System.out.println("min ele = " + ints[0]);
    }

    private static void Ques4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("First num ???");
        int a = sc.nextInt();
        System.out.println("Sec num ???");
        int b = sc.nextInt();
        System.out.println(a - b > 0 ? "a > b" : " a < b");
    }

    private static void Ques5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("First num ???");
        int a = sc.nextInt();
        System.out.println("Sec num ???");
        int b = sc.nextInt();
        System.out.println(a % b == 0 ? "a % b" : " a !% b");
    }
    //
    private static void Ques6() {
        Scanner sc = new Scanner(System.in);
        // var
        int p1, p2, p3;
        p1 = p2 = p3 = -1;
        String rank = "";
        // var meunu
        int choose;
        while (true) {
            System.out.println("1. Nhập vào điểm 3 môn học");
            System.out.println("2. Tính điểm trung bình");
            System.out.println("3. Xác định học lực của học sinh dựa trên điểm trung bình");
            System.out.println("4. Hiển thị học lực của học sinh\n");

            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    do {
                        System.out.println("p1 ??");
                        p1 = sc.nextInt();
                        System.out.println("p2 ??");
                        p2 = sc.nextInt();
                        System.out.println("p3 ??");
                        p3 = sc.nextInt();
                        if (p1 < 0 || p2 < 0 || p3 < 0) System.out.println("?? Again");
                    } while (p1 < 0 || p2 < 0 || p3 < 0);
                    break;
                case 2:
                    if (p1 == -1 || p2 == -1 || p3 == -1) {
                        System.out.println("point not init ???");
                    } else {
                        float avg = (p1 + p2 + p3) * 1.0f / 3;
                        System.out.println("avg = " + avg);
                    }
                    break;
                case 3:
                    if (p1 == -1 || p2 == -1 || p3 == -1) {
                        System.out.println("point not init ???");
                    } else {
                        float diem = ((p1) * 2 + p2 + p3) * 1.0f / 4;
                        if (diem >= 9.0) {
                            rank = "XS";
                        } else if (8.0 <= diem && diem < 9.0) {
                            rank = "G";
                        } else if (7.0 <= diem && diem < 8.0) {
                            rank = "K";
                        } else if (6.0 <= diem && diem < 7.0) {
                            rank = "TBK";
                        } else if (5.0 <= diem && diem < 6.0) {
                            rank = "TB";
                        } else {
                            rank = "K";
                        }
                    }
                    break;
                case 4:
                    if (p1 == -1 || p2 == -1 || p3 == -1) {
                        System.out.println("point not init ???");
                    } else System.out.println("Rank = " + rank);
                    break;
                default:
                    System.out.println("Again ??");
                    break;
            }
        }
    }
}
