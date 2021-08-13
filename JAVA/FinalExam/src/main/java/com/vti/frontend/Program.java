package com.vti.frontend;

import com.vti.entity.User;
import com.vti.frontend.function.ManagerFunction;
import com.vti.frontend.function.ProjectFunction;
import com.vti.frontend.function.UserFunction;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        menuLogin();
    }

    private static void menuLogin() throws SQLException, IOException, ClassNotFoundException {
        ManagerFunction managerFunction = new ManagerFunction();
        ProjectFunction projectFunction = new ProjectFunction();
        UserFunction userFunction = new UserFunction();

        System.out.println("MỜI BẠN LOGIN");
        User user = userFunction.login();
        System.out.println("Login successfull!");
        System.out.println("Chào mừng " + user.getFullName() + "!");

        menu(managerFunction, projectFunction);
    }

    private static void menu(ManagerFunction managerFnc, ProjectFunction projectFnc) throws ClassNotFoundException, IOException, SQLException {
        System.out.println("Mời bạn nhập chức năng muốn sử dụng\n"
                + "------- 1: In ra Employee và Manager trong project theo Id -------\n"
                + "------- 2: In các manager các project                      -------\n"
                + "------- 3: Login                                           -------\n"
                + "------- 4: Thoat khoi chuong trinh                         -------\n ");

        while (true) {
            System.out.print("Mời bạn nhập chức năng: ");
            int choose = ScannerUtils.getInstance().inputInt("Sai định dạng");

            switch (choose) {
                case 1:
                    projectFnc.getProjectById();
                    break;
                case 2:
                    managerFnc.getListManagerOfProject();
                    break;
                case 3:
                    menuLogin();
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình!");
                    JdbcUtils.getInstance().disconnect();
                    return;
                default:
                    System.out.println("Nhập lại!");
                    break;
            }
        }
    }
}
