package com.vti.entity.ex2;

import java.time.LocalDate;
import java.util.Comparator;

public class StudentComparator implements Comparator<StudentComparator> {
    private int id;
    private String name;
    private LocalDate age;
    private float mark;

    public StudentComparator(int id, String name, LocalDate age, float mark) {
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
    public int compare(StudentComparator o1, StudentComparator o2) {
        int comName = o1.getName().compareTo(o2.getName());
        int comAge = o1.getAge().compareTo(o2.getAge());
        int comMark = Float.compare(o1.getMark(), o2.getMark());

        return comName == 0 ? (comAge == 0 ? comMark : comAge) : comName;
    }
}
