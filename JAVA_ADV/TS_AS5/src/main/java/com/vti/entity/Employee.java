package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(columnDefinition = "AccountID")
public class Employee extends Account implements Serializable {

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private byte workingNumberOfYear;
}
