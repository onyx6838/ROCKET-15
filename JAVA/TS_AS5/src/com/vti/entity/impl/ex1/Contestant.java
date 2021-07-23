package com.vti.entity.impl.ex1;

public class Contestant {
    private int id;
    private String name;
    private String address;
    private int priority;
    private Block block;
    public static int COUNT = 0;

    public Contestant(String name, String address, int priority, Block block) {
        this.id = COUNT++;
        this.name = name;
        this.address = address;
        this.priority = priority;
        this.block = block;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", priority=" + priority +
                ", block=" + block.getSubject() +
                '}';
    }
}
