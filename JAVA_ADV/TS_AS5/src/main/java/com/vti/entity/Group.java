package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "group")
public class Group {
    @Id
    @Column(name = "GroupID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false)
    private Account creatorId;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "group")
    private List<GroupAccount> accounts;
}
