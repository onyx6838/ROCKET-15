package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private int id;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "Member", columnDefinition = "INT default 0")
    private int member;

    @OneToMany(mappedBy = "group")
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "Creator")
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;
}
