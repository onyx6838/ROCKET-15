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

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "`Group`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {
    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "Member")
    private int member;

    @OneToMany(mappedBy = "group")
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "Creator", nullable = false, updatable = false)
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Group(String name) {
        this.name = name;
    }
}
