package com.vti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.entity.primarykey.GroupAccountKey;

@Entity
@Table(name = "GroupAccount")
public class GroupAccount {

	@EmbeddedId
	private GroupAccountKey id;

	@ManyToOne
	@MapsId("AccountID")
	@JoinColumn(name = "AccountID")
	private Account account;

	@ManyToOne	// @ManyToMany của bảng trung gian
	@MapsId("GroupID")	// bảng chính
	@JoinColumn(name = "GroupID")	// bảng trung gian
	private Group group;

	@Column(name = "JoinDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;

	public GroupAccount() {
	}

	public GroupAccountKey getId() {
		return id;
	}

	public void setId(GroupAccountKey id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
