package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "company_groups")
public class CompanyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private short id;

    @Column(name = "group_name", unique = true, nullable = false)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Account creator;

    @Column(name = "create_date")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    @OneToMany(mappedBy = "companyGroup", orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<GroupAccount> groupAccounts;

    @Override
    public String toString() {
        return "CompanyGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
