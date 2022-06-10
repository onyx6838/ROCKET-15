package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public int id;
	public String content;
	public TypeQuestion typeQuestion;
	public CategoryQuestion categoryQuestion;
	public Account creator;
	public LocalDate createDate;
}
