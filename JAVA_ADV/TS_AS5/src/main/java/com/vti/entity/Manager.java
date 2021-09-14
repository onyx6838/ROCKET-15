package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "manager", schema = "hb_ts_as5", catalog = "")
public class Manager {
    @Id
    @Column(name = "AccountID")
    private byte id;

    @Column(name = "ManagementNumberOfYear")
    private byte managementNumberOfYear;

    @OneToMany(mappedBy = "account")
    private List<Account> accounts;
}
