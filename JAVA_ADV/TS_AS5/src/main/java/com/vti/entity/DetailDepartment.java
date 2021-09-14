package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detaildepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department  implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint;
}
