package com.vti.frontend;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException, IOException {
        AccountController accountController = new AccountController();
        // C
//        Account account = new Account(
//            "account5@gmail.com","Account5","Nguyen A",new Department(5),
//                LocalDate.parse("2020-03-05")
//        );
//        accountController.createAccount(account);
        // R
        List<Account> accounts = accountController.getListAccounts();
        accounts.forEach(System.out::println);
        // U
//        Account accountUpdate = new Account(
//                "account5@gmail.com", "Account5", "Nguyen Van A", new Department(5),
//                LocalDate.parse("2020-03-05")
//        );
//        accountController.updateAccountById(13, accountUpdate);
        // D
//        accountController.deleteAccount(13);
    }
}
