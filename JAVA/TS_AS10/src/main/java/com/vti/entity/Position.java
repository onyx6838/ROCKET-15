package com.vti.entity;

public class Position {
    public int id;
    public PositionName name;

    public Position() {
    }

    public Position(int id, PositionName name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }
}
