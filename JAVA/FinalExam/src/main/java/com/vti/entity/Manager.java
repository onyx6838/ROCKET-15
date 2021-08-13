package com.vti.entity;

public class Manager extends User {
    private int expInYear;
    private int projectManageId;

    public Manager(int id, String fullName, Role role, int expInYear, int projectManageId) {
        super(id, fullName, role);
        this.expInYear = expInYear;
        this.projectManageId = projectManageId;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public int getProjectManageId() {
        return projectManageId;
    }

    public void setProjectManageId(int projectManageId) {
        this.projectManageId = projectManageId;
    }

    @Override
    public String toString() {
        String t = super.toString() + " | " + " expInYear = " + expInYear + " | " + projectManageId;
        return t;
    }
}
