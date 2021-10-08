package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.authentication.ResetPasswordToken;

public interface IResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer> {

    ResetPasswordToken findByToken(String token);

    boolean existsByToken(String token);

    @Transactional
    @Modifying
    @Query("	DELETE 						"
            + "	FROM 	ResetPasswordToken 	"
            + " WHERE 	account.id = :accountId")
    void deleteByUserId(int accountId);

}
