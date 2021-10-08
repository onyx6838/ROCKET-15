package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.authentication.RegistrationUserToken;

public interface IRegistrationAccountTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {

    RegistrationUserToken findByToken(String token);

    boolean existsByToken(String token);


    @Query("	SELECT 	token	"
            + "	FROM 	RegistrationUserToken "
            + " WHERE 	account.id = :accountId")
    String findByAccountId(int accountId);

    @Transactional
    @Modifying
    @Query("	DELETE 							"
            + "	FROM 	RegistrationUserToken 	"
            + " WHERE 	account.id = :accountId")
    void deleteByAccountId(int accountId);
}
