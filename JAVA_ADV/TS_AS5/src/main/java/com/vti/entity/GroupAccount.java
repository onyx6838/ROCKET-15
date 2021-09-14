package com.vti.entity;

import com.vti.entity.primarykey.GroupAccountPK;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("JpaModelReferenceInspection")
@Entity
@Data
@NoArgsConstructor
@Table(name = "groupaccount")
public class GroupAccount implements Serializable {
    @EmbeddedId
    private GroupAccountPK id;

    @ManyToOne
    @MapsId("AccountID")
    @JoinColumn(name = "AccountID")
    private Account account;

    @ManyToOne
    @MapsId("GroupID")
    @JoinColumn(name = "GroupID")
    private Group group;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;
}
