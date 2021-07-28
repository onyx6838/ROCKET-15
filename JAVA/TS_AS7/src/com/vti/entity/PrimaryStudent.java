package com.vti.entity;

public class PrimaryStudent extends Student {
    public static int COUNTPriStu = 0;

    public PrimaryStudent() {
        COUNTPriStu++;
    }

    public PrimaryStudent(int id, String name) {
        super(id, name);
        COUNTPriStu++;
    }

}
