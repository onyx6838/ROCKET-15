package com.vti.entity;

public class SecondaryStudent extends Student {
    public static int COUNTSecStu = 0;

    public SecondaryStudent() {
        COUNTSecStu++;
    }

    public SecondaryStudent(int id, String name) {
        super(id, name);
        COUNTSecStu++;
    }
}
