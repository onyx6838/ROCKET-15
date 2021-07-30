package com.vti.backend;

import com.vti.entity.ex3.Employee;
import com.vti.entity.ex3.Phone;
import com.vti.entity.ex3.Staff;
import com.vti.entity.ex3.Student;
import com.vti.utils.MyMap;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public void Ques2() {
        printInfoStu(new Student(1, "Nguyen Van A"));
        printInfoStu(4);
        printInfoStu(4.0);
    }

    // method ques2
    public <T> void printInfoStu(T info) {
        System.out.println(info);
    }

    public void Ques4() {
        List<Float> list = new ArrayList<>();
        list.add(1f);
        list.add(2f);
        list.add(3f);
        list.add(4f);
        printEle(list);
    }

    // method ques 4
    public <E> void printEle(List<E> list) {
        list.forEach(x -> System.out.println(x.toString()));
    }

    public void Ques5() {
        List<Integer> salaries = new ArrayList<>();
        salaries.add(100);
        salaries.add(150);
        salaries.add(300);
        salaries.add(250);
        salaries.add(400);
        Employee employee = new Employee(1, "ng Van A", salaries);
        employee.printInfo();
        employee.printLastSalary();
    }

    public void Ques6() {
        MyMap<Integer, String> Student = new MyMap<>(1, "Student");
        System.out.println(Student);
    }

    public void Ques7() {
        Phone<String, String> phone = new Phone<>("@.com", "0123");
        Phone<Integer, String> phone1 = new Phone<>(12, "0123");
        Phone<String, String> phone2 = new Phone<>("gggg", "0123");
    }

    public void Ques8() {
        Staff phone = new Staff("fff", "ff");
    }
}
