package com.vti.entity;

public class CategoryQuestion {
    public int id;
    public int name;

    public CategoryQuestion() {

    }

    public CategoryQuestion(int id, int name) {
        this.id = id;
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}
}
