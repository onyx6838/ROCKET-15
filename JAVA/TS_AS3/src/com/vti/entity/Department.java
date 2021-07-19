package com.vti.entity;

import java.util.Objects;

public class Department{
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Department d = (Department) o;
        return this.name.equals(d.name) ? true : false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
