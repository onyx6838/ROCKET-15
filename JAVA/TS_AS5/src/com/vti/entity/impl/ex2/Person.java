package com.vti.entity.impl.ex2;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
    private String name;
    private Gender gender;
    private LocalDate dob;
    private String address;

    public Person() {

    }

    public Person(String name, Gender gender, LocalDate dob, String address) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin :");
        System.out.println("Name: ");
        this.name = sc.next();
        System.out.println("Gender 1.Male, 2.Female, 3.Unknown: ");
        int flagGender = sc.nextInt();
        switch (flagGender) {
            case 1:
                this.gender = Gender.MALE;
                break;
            case 2:
                this.gender = Gender.FEMALE;
                break;
            case 3:
                this.gender = Gender.UNKNOWN;
                break;
            default:
                System.out.println("Sai gender");
                break;
        }
        System.out.println("BirthDate nhập theo định dạng yyyy-MM-dd: ");
        this.dob = LocalDate.parse(sc.next());
        System.out.println("Address: ");
        this.address = sc.next();
    }

    public void showInfo() {
        System.out.println("Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender.name() +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}');
    }
}
