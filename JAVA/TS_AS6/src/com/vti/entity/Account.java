package com.vti.entity;

import com.vti.config.exception.InvalidAgeInputingException;
import com.vti.utils.ScannerUtils;

import java.time.LocalDate;

public class Account {
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private LocalDate createDate;
    private int age;

    public Account() {
    }

    public Account(int id, String email, String userName, String fullName, LocalDate createDate) throws InvalidAgeInputingException {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.createDate = createDate;
        this.age = inputAge();
    }

    public int inputAge() throws InvalidAgeInputingException {
        int age;
        while (true){
            age = ScannerUtils.inputInt("Sai form");
            if (age < 0) {
                throw new InvalidAgeInputingException("The age must be greater than 0");
            } else if (age < 18) {
                System.out.println("Your age must be greater than 18");
            } else return age;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}