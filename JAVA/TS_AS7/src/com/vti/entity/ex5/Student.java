package com.vti.entity.ex5;

import com.vti.utils.ScannerUtils;

public class Student {
    private int id;
    private String name;

    public Student() {
        System.out.println("Input id ??");
        this.id = (int) ScannerUtils.inputPreventPositive("Incorrect Input",Integer.class);
        System.out.println("Input name ??");
        this.name = ScannerUtils.inputString("not empty");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
