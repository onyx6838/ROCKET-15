package com.vti.frontend;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise4 {
    private static Random random = new Random();

    public static void main(String[] args) {
        Ques1();
        Ques2();
        Ques3();
        LocalDate d1 = LocalDate.of(1995, 7, 24);
        LocalDate d2 = LocalDate.of(1995, 12, 20);
        Ques4(d1, d2);
        Ques5();
        Ques6();
        Ques7();
    }

    private static void Ques1() {
        System.out.println("Random Integer number :" + random.nextInt());
    }

    private static void Ques2() {
        System.out.println("Random Float number :" + random.nextFloat());
    }

    private static void Ques3() {
        String[] names = {"A", "B", "C", "D"};
        int indexRandom = random.nextInt(names.length);
        //System.out.println("Random string with random index: " + names[random.nextInt(names.length)]);
        System.out.println("Random string with random index: " + names[indexRandom]);
    }

    private static void Ques4(LocalDate d1, LocalDate d2) {
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
        // == Date
        /*Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));
        System.out.println(randomDate.toString());*/
        long minDay = d1.toEpochDay();  // Lấy ra số ngày nhỏ nhất tính từ 01/01/1970
        long maxDay = d2.toEpochDay();  // Lấy ra số ngày lớn nhất tính từ 01/01/1970
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);  // ngau nhien epoch r convert
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay); // convert
        System.out.println(randomDate);
    }

    private static void Ques5() {
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
        int maxDay = (int) LocalDate.now().toEpochDay();
        int randomDay = random.nextInt(365);
        LocalDate date = LocalDate.ofEpochDay(randomDay);
        System.out.println("Ques5: " + date);
    }

    private static void Ques6() {
        //Lấy ngẫu nhiên 1 ngày trong quá khứ
        int maxDay = (int) LocalDate.now().toEpochDay();
        int randomDay = random.nextInt(maxDay);
        LocalDate date = LocalDate.ofEpochDay(randomDay);
        System.out.println("Ques6: " + date);
    }

    private static void Ques7() {
        //Lấy ngẫu nhiên 1 số có 3 chữ số
        int n = random.nextInt(999 - 100 + 1) + 100;
        // Công thức: (sốmax - số min + 1) + số min
        System.out.println("Ques7: " + n);
    }
}
