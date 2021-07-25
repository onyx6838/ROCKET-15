package com.vti.frontend;

import com.vti.entity.Department;

public class Program2_Ques4 {
    public static void main(String[] args) {
        Department[] departments = new Department[3];
        getIndex(4, departments);
    }

    public static Department getIndex(int index, Department[] departments) {
        Department department = null;
        try {
            department =  departments[index];
        } catch (Exception e) {
            System.out.println("Cannot find department");
        }
        return department;
    }
}
