package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Student {
    private String name;
    private int age;

    public Student() throws Exception {
        name = ScannerUtils.inputString("Nhập chuỗi");
        age = (int) ScannerUtils.inputPreventPositive("Nhập đúng định dạng tuổi và < 0", Integer.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
