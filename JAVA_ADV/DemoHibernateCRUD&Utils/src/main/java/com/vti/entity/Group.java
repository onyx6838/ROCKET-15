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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "`Group`", catalog = "TestingSystem5")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "CreatorID", nullable = false)
	private Account creator;

	@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
	private List<GroupAccount> accounts;

	public Group() {
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public List<GroupAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<GroupAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		for (GroupAccount groupAccount : accounts) {
			System.out.println(groupAccount.getAccount().getFullName());
			System.out.println(groupAccount.getJoinDate());
		}
		System.out.println();
		return "Group [id=" + id + ", name=" + name + ", createDate=" + createDate + ", creator="
				+ creator.getFullName() + "]";
	}

}
