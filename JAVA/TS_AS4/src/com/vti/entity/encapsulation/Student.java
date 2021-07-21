package com.vti.entity.encapsulation;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private float mark;

    public Student() {
    }

    public Student(String name, String homeTown) {
        this.name = name;
        this.homeTown = homeTown;
        this.mark = 0;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void plusMark(float mark) {
        this.mark += mark;
    }

    public void display() {
        System.out.println(this.name);
        String rank;
        if (this.mark > 8) rank = "gioi";
        else if (this.mark > 6 && this.mark < 8) rank = "kha";
        else if (this.mark > 4 && this.mark < 6) rank = "tb";
        else rank = "yeu";
        System.out.println("Hoc luc " + rank);
    }
}
