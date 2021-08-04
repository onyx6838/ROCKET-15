package com.vti.backend;

import com.vti.entity.Student;

import java.util.Calendar;
import java.util.Date;

public class Exercise2 {
    @SuppressWarnings("deprecation")
    public void Ques1() {
        Date date = new Date(2020, Calendar.JUNE, 18);
        System.out.println(date);
    }

    public void Ques2() {
        Student student = new Student("MG");
        System.out.println(student.getId());
        System.out.println(student.getIdV2());
    }
}
