package com.vti.entity.authentication;

import com.vti.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`Token`")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.STRING)
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    protected int id;

    @Column(name = "`token`", nullable = false, unique = true)
    protected String token;

    @OneToOne
    @JoinColumn(name = "AccountID", nullable = false)
    protected Account account;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`ExpiredDate`", nullable = false)
    protected Date expiredDate;

    public Token(String token, Account account, long expiredTime) {
        this.token = token;
        this.account = account;
        expiredDate = new Date(System.currentTimeMillis() + expiredTime);
    }
}
