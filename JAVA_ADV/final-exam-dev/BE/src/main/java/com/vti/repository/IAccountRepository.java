package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.enumerate.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    boolean existsByUsername(String userName);

    boolean existsByEmail(String email);

    @Query("	SELECT 	status		"
            + "	FROM 	Account 		"
            + " WHERE 	email = :email")
    UserStatus findStatusByEmail(String email);

    Account findByUsername(String name);

    Account findByEmail(String email);
}
