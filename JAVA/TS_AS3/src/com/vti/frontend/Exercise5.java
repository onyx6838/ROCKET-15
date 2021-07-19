package com.vti.frontend;

import com.vti.entity.Department;

public class Exercise5 {
    public static void main(String[] args) {
        Department[] departments = new Department[5];
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";
        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";
        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Boss of director";
        Department department4 = new Department();
        department4.id = 4;
        department4.name = "Waiting room";
        Department department5 = new Department();
        department5.id = 5;
        department5.name = "Accounting";
        departments[0] = department1;
        departments[1] = department2;
        departments[2] = department3;
        departments[3] = department4;
        departments[4] = department5;
    }

    public static void Ques1(Department department) {
        System.out.println(department.toString());
    }

    public static void Ques2(Department[] departments) {
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    public static void Ques3(Department department) {
        System.out.println(department.hashCode());
    }

    public static void Ques4(Department department) {
        System.out.println(department.name.equals("Sale"));
    }

    public static void Ques5(Department department1, Department department2) {
        System.out.println(department1.equals(department2) ? "= nhau" : "k = nhau");
    }


    public static void Ques6(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            for (int j = i + 1; j < departments.length - 1; j++) {
                if (departments[i].name.compareToIgnoreCase(departments[j].name) > 0) {
                    Department temp = departments[j];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }
    }

    public static void Ques7(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            for (int j = i + 1; j < departments.length - 1; j++) {
                if (getFirstCharacOfLastWord(departments[i].name).compareToIgnoreCase(getFirstCharacOfLastWord(departments[i].name)) > 0) {
                    Department temp = departments[j];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }
    }

    public static String getFirstCharacOfLastWord(String word) {
        String[] arrayWord = word.trim().split("\\s+");
        for (int i = 0; i < arrayWord.length; i++) {
            arrayWord[i] = arrayWord[i].substring(0, 1);
        }
        return arrayWord[arrayWord.length - 1];
    }
}
