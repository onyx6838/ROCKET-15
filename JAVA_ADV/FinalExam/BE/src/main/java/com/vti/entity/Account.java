package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.annotations.Formula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`Account`")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

  @Column(name = "password", length = 800, nullable = false)
  private String password;

  @Column(name = "FirstName", length = 50, nullable = false)
  private String firstName;

  @Column(name = "LastName", length = 50, nullable = false)
  private String lastName;

  @Formula(" concat(FirstName, ' ', LastName) ")
  private String fullName;

  @Column(name = "Role", nullable = false)
  private String role;

  @ManyToOne
  @JoinColumn(name = "DepartmentID")
  private Department department;

  @OneToMany(mappedBy = "author")
  private List<Department> createdDepartment;

  @Column(name = "CreateDate")
  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createDate;

}
