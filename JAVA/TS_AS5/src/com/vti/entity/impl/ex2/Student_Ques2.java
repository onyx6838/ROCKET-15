package com.vti.entity.impl.ex2;

import java.time.LocalDate;
import java.util.Scanner;

public class Student_Ques2 extends Person {
    private int id;
    private float average;
    private String email;

    public Student_Ques2(int id, float average, String email) {
        this.id = id;
        this.average = average;
        this.email = email;
    }

    public Student_Ques2(String name, Gender gender, LocalDate dob, String address, int id, float average, String email) {
        super(name, gender, dob, address);
        this.id = id;
        this.average = average;
        this.email = email;
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
        System.out.println("ID: ");
        this.id = sc.nextInt();
        System.out.println("GradeAvg: ");
        this.average = sc.nextFloat();
        System.out.println("email: ");
        this.email = sc.next();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Student {" +
                "id=" + id +
                ", average=" + average +
                ", email='" + email + '\'' +
                '}');
    }

    public boolean scholarship() {
        return average > 8.0 ? true : false;
    }
}
