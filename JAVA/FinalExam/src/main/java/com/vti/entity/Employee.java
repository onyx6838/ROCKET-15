package com.vti.entity;

public class Employee extends User {
    private int projectId;
    private String proSkill;

    public Employee() {
    }

    public Employee(int id, String fullName, Role role, int projectId, String proSkill) {
        super(id, fullName, role);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
