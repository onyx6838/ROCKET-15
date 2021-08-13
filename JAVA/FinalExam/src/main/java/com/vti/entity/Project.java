package com.vti.entity;

import java.util.List;

public class Project {
    private int projectId;
    private int teamSize;
    private int idManager;
    private List<Integer> idEmployees;
    private List<User> participants;

    public Project() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public List<Integer> getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(List<Integer> idEmployees) {
        this.idEmployees = idEmployees;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Project : " + " projectId + " + projectId + " teamSize= " + teamSize;
    }
}
