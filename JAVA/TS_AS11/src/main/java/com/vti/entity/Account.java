package com.vti.entity;

import java.time.LocalDate;

public class Account {
    private int id;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String fullName;
    private Department department;
    private Position position;
    private LocalDate createDate;
    private Group[] groups;

    public Account() {
    }

    public Account(int id, String email, String userName, String fullName, Department department, LocalDate createDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.createDate = createDate;
    }

    public Account(String email, String userName, String fullName, Department department, LocalDate createDate) {
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.createDate = createDate;
    }

    public Account(String username) {
        this.userName = username;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "id = " + id +
                " | email = " + email +
                " | userName = " + userName +
                " | fullName = " + fullName +
                " | departmentName = " + department.getName() +
                " | createDate = " + createDate;
    }
}