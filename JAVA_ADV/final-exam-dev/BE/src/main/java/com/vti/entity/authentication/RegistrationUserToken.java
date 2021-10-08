package com.vti.entity.authentication;

import com.vti.entity.Account;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RegistrationUserToken")
@NoArgsConstructor
public class RegistrationUserToken extends Token {
    public RegistrationUserToken(String token, Account account, long expiredTime) {
        super(token, account, expiredTime);
    }
}
