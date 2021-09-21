package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Data
@Table(name = "Department", catalog = "jpa_test")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "TotalMember")
    private short totalMember;

    public Department(String name) {
        this.name = name;
    }
}
