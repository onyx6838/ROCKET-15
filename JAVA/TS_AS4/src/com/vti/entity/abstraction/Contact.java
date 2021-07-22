package com.vti.entity.abstraction;

public class Contact {
    private String number;
    private String name;

    public Contact() {

    }

    public Contact(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
