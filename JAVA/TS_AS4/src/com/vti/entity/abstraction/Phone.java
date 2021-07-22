package com.vti.entity.abstraction;

import java.util.ArrayList;

public abstract class Phone {
    public ArrayList<Contact> contacts;

    public Phone(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public abstract void insertContact(String name, String phone);

    public abstract void removeContact(String name);

    public abstract void updateContact(String name, String newPhone);

    public abstract void searchContact(String name);
}
