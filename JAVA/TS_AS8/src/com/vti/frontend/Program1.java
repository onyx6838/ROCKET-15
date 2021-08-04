package com.vti.frontend;

import com.vti.backend.*;
import com.vti.entity.Student;

public class Program1 {
    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();
        ex1.Ques67();

        Student student = new Student("Giang");
        print(student);
    }

    @Deprecated
    public static void print(Student student) {
        System.out.println(student);
    }

    public static void printV2(Student student) {
        if (student == null) System.out.println("ssss");
        else System.out.println(student);
    }
}
