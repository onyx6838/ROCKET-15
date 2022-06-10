package com.vti.program;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

import java.util.List;

public class AccountProgram {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        System.out.println("List of accounts");
        List<Account> result = accountRepository.getAllAccounts();
        result.forEach(System.out::println);

        System.out.println("Find By AccountId = 1");
        Account rs = accountRepository.getById(1);
        rs.getCompanyGroupsByCreator().forEach(System.out::println);
    }
}
