package com.vti.backend;

import com.vti.entity.encapsulation.Student;

public class Exercise4 {
    public void Ques1() {
        Student student = new Student("Giang", "QN");
        student.plusMark(5f);
        student.display();
    }
}
