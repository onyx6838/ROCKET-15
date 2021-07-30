package com.vti.entity.ex3;

public class Phone<K, V> {
    private K key;
    private V phoneNumber;

    public Phone(K key, V phoneNumber) {
        this.key = key;
        this.phoneNumber = phoneNumber;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(V phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
