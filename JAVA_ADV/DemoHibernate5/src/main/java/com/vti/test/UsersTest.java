package com.vti.test;

import com.vti.entity.Users;
import com.vti.repository.UsersRepository;

import java.util.List;

public class UsersTest {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository();

        List<Users> usersList = usersRepository.getAllUsers();
        usersList.forEach(System.out::println);
    }
}
