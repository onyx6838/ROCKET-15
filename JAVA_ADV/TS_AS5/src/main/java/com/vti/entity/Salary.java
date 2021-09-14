package com.vti.entity;

import com.vti.entity.enumerate.SalaryName;
import com.vti.entity.enumerate.SalaryNameConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @Column(name = "SalaryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;


    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName salaryName;
}
