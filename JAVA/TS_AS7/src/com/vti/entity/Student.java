package com.vti.entity;

public class Student {
    private int id;
    private String name;
    public static String college;
    public static int moneyGroup;

    public static int COUNT = 0;

    public Student() {

    }

    public Student(int id, String name) {
        COUNT++;
        if (COUNT > 7) {
            System.out.println("Max 7 Student");
        } else {
            this.id = id;
            this.name = name;
            Student.college = "HUST";
        }
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' + ", college='" + college + '\'' +
                '}';
    }
}
