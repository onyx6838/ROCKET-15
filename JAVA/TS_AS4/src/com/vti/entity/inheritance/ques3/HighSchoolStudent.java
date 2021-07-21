package com.vti.entity.inheritance.ques3;

public class HighSchoolStudent extends Student {
    private String clazz;
    private String desiredUniversity;

    public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
        super(name, id);
        this.clazz = clazz;
        this.desiredUniversity = desiredUniversity;
    }

}
