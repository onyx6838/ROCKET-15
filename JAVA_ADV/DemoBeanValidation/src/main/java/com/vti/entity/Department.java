package entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Department {
	private short id;

	@Size(min = 6, max = 50, message = "The name must be at least 6 character and max 50 character")
	private String name;

	@Min(value = 0, message = "The total member must be greater than 0")
	private short totalMember;

	public Department() {
	}

	public Department(String name, short totalMember) {
		this.name = name;
		this.totalMember = totalMember;
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

	public short getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(short totalMember) {
		this.totalMember = totalMember;
	}

}
