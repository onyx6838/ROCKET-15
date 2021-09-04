package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`Account`", catalog = "TestingSystem5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "FirstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "LastName", length = 50, nullable = false)
	private String lastName;

	@Formula(" concat(FirstName, ' ', LastName) ")
	private String fullName;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartmentID", nullable = false)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = false)
	private Position position;

	@ManyToOne
	@JoinColumn(name = "SalaryID", nullable = false)
	private Salary salary;

	@OneToMany(mappedBy = "creator")
	private List<Group> createdGroup;

	@OneToMany(mappedBy = "account") // bảng Account từ bảng chính sang bảng tgian
	private List<GroupAccount> groups; // đặt tên

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fullName=" + fullName + ", department=" + department + ", position="
				+ position + ", salary=" + salary + ", createDate=" + createDate + "]";
	}

}
