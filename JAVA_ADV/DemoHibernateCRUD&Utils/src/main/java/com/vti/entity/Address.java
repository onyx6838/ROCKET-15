package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address", catalog = "TestingSystem5")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "AddressName", length = 100, nullable = false, unique = true)
	private String name;

	@OneToOne(mappedBy = "address")
	private DetailDepartment department;

	public DetailDepartment getDepartment() {
		return department;
	}

	public void setDepartment(DetailDepartment department) {
		this.department = department;
	}

	public Address() {
	}

	public Address(String name) {
		this.name = name;
	}

	public Address(short id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + "]";
	}

}
