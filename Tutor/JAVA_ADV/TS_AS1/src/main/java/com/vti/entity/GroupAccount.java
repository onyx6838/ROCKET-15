package com.vti.entity;

import com.vti.entity.pk.GroupAccountId;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "group_accounts")
public class GroupAccount {
    @EmbeddedId
    private GroupAccountId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("groupId")
    private CompanyGroup companyGroup;

    @Column(name = "join_date")
    private Date createdOn;

    @Override
    public String toString() {
        return "GroupAccount{" +
                "id=" + id +
                ", account=" + account.getUsername() +
                ", companyGroup=" + companyGroup.getGroupName() +
                ", createdOn=" + createdOn +
                '}';
    }
}
