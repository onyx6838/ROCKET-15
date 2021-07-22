package com.vti.entity.abstraction;

import java.util.ArrayList;

public class VietnamesePhone extends Phone {
    public VietnamesePhone(ArrayList<Contact> contacts) {
        super(contacts);
    }

    @Override
    public void insertContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
    }

    @Override
    public void removeContact(String name) {
        contacts.removeIf(x -> x.getName().equals(name));
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (Contact c : contacts) if (c.getName().equals(name)) c.setNumber(newPhone);
    }

    @Override
    public void searchContact(String name) {
        contacts.stream().filter(x -> x.getName().equals(name)).forEach(System.out::println);
    }

    public void printContactList() {
        contacts.stream().forEach(System.out::println);
    }
}
