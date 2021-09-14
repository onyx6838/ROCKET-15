package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "department")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

}
