package com.vti.frontend.function;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class UserFunction {
    private UserController userController;

    public UserFunction() throws SQLException, IOException {
        userController = new UserController();
    }

    public User login() {
        while (true) {
            System.out.println("Mời bạn nhập vào Email của account: ");
            String email = ScannerUtils.getInstance().inputEmail("Email chưa đúng định dạng.");

            System.out.println("Mời bạn nhập password: ");
            String password = ScannerUtils.getInstance().inputPassword("Password phai dai tu 6 -> 12 ki tu va co it nhat 1 chu viet hoa!");
            try {
                return userController.login(email, password);
            } catch (Exception e) {
                System.err.println(e.getMessage() + "\n");
            }
        }
    }
}
