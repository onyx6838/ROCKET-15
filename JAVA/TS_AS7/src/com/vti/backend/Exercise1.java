package com.vti.backend;

import com.vti.config.exception.HinhHocException;
import com.vti.entity.*;
import com.vti.utils.ScannerUtils;

import java.util.Arrays;

public class Exercise1 {
    public void Ques1() {
        Student student1 = new Student(1, "Nguyễn Văn A");
        Student student2 = new Student(2, "Nguyễn Văn B");
        Student student3 = new Student(3, "Nguyễn Văn C");
        Student.college = "HUST";
        Student[] students = new Student[]{student1, student2, student3};
        Arrays.stream(students).forEach(System.out::println);
        System.out.println("Thay doi static sang VNU");
        Student.college = "VNU";
        Arrays.stream(students).forEach(System.out::println);
    }

    public void Ques2() {
        Student student1 = new Student(1, "Nguyễn Văn A");
        Student student2 = new Student(2, "Nguyễn Văn B");
        Student student3 = new Student(3, "Nguyễn Văn C");
        Student.college = "VNU";
        //
        Student.moneyGroup += 300;
        System.out.println("Student 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");
        System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 50));
        System.out.println("Student 2 lấy 20k đi mua bánh mì: ");
        System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 20));
        System.out.println("Student 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
        System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
        System.out.println("Cả nhóm mỗi người lại đóng quỹ mỗi người 50k:");
        System.out.println("Tổng quỹ: " + (Student.moneyGroup += 150));
    }

    public void Ques5() {
        System.out.println("Số student đc sinh ra " + Student.COUNT);
    }

    public void Ques6() {
        System.out.println("Tạo 2 Primary Student: ");
        PrimaryStudent pSt1 = new PrimaryStudent();
        PrimaryStudent pSt2 = new PrimaryStudent();
        System.out.println("Tạo 6 Secondary Student: ");
        SecondaryStudent sST1 = new SecondaryStudent();
        SecondaryStudent sST2 = new SecondaryStudent();
        SecondaryStudent sST3 = new SecondaryStudent();
        SecondaryStudent sST4 = new SecondaryStudent();
        SecondaryStudent sST5 = new SecondaryStudent();
        SecondaryStudent sST6 = new SecondaryStudent();
        System.out.println("Thông tin số lượng sinh viên");
        String leftAlignFormat = "| %-18s | %-4d |%n";
        System.out.format("+--------------------+------+%n");
        System.out.format("| Category           | SL   |%n");
        System.out.format("+--------------------+------+%n");
        System.out.format(leftAlignFormat, "Student", Student.COUNT);
        System.out.format(leftAlignFormat, "PrimaryStudent", PrimaryStudent.COUNTPriStu);
        System.out.format(leftAlignFormat, "SecondaryStudent", SecondaryStudent.COUNTSecStu);
        System.out.format("+--------------------+------+%n");
    }

    public void Ques7() {

    }

    public void Ques8() throws HinhHocException {
        System.out.println("Tạo 4 hình chữ nhật.");
        HinhChuNhat[] hcns = new HinhChuNhat[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Hình " + (i + 1) + ":");
            System.out.println("Canh a: ");
            float a = ScannerUtils.inputFloat("Incorrect Input");
            System.out.println("Canh b: ");
            float b = ScannerUtils.inputFloat("Incorrect Input");
            HinhChuNhat hcn = new HinhChuNhat(a, b);
            hcns[i] = hcn;
        }
        System.out.println("Tạo hình tròn số 1, nhập vào bán kính ");
        float r1 = ScannerUtils.inputFloat("Incorrect Input");
        HinhTron hinhtron1 = new HinhTron(r1, r1);
        System.out.println("Tạo hình tròn số 2, nhập vào bán kính ");
        float r2 = ScannerUtils.inputFloat("Incorrect Input");
        HinhTron hinhtron2 = new HinhTron(r2, r2);
    }
}
