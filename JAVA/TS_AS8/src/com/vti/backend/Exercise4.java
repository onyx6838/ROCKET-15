package com.vti.backend;

import com.vti.entity.ex4.Salary;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    public void Ques1() {
        Salary<Integer> salary = new Salary<>(1);
        salary.print();
    }

    public void Ques2() {

    }

    public void question5() {
        List<Object> inforCustomers = new ArrayList<>();
        inforCustomers.add("Nguyễn Văn Nam");
        inforCustomers.add(30);
        inforCustomers.add("Hà đông, Hà nội");

        for (Object object : inforCustomers) {
            System.out.println(object);
        }
    }
}
