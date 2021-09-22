package entity;

import java.util.Date;

import javax.validation.constraints.Size;

import com.vti.beanvalidation.Age;

public class Account {
	private short id;

	@Size(min = 6, max = 50, message = "The name must be at least 6 character and max 50 character")
	private String name;

	@Age(min = 18)
	private Date birthDay;

	public Account() {
	}

	public Account(String name, Date birthDay) {
		this.name = name;
		this.birthDay = birthDay;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
