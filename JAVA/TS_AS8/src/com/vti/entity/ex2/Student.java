package com.vti.entity.ex2;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private LocalDate age;
    private float mark;

    public Student(int id, String name, LocalDate age, float mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
