package com.vti.entity.impl.ex1;

public class Block {
    private String name;
    private String subject;

    public Block(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        switch (this.name){
            case "A":
                this.subject = "T, L, H";
                break;
            case "B":
                this.subject = "T, H, S";
                break;
            case "C":
                this.subject = "V, S, D";
                break;
            default:
                break;
        }
        return this.subject;
    }
}
