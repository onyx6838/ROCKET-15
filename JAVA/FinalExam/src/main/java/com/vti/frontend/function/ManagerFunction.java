package com.vti.frontend.function;

import com.vti.backend.presentationlayer.ManagerController;
import com.vti.entity.Manager;
import com.vti.entity.Role;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManagerFunction {
    private ManagerController controller;

    public ManagerFunction() throws SQLException, IOException {
        controller = new ManagerController();
    }

    public void getListManagerOfProject() throws SQLException {
        List<Manager> managerList = controller.getListManagerOfProject(Role.MANAGER.toString());
        System.out.println("Manager List With Role " + Role.MANAGER.toString());
        String leftAlignFormat = "| %-9d | %-18s | %-7s | %-8d | %-9d |%n";
        System.out.format("+-----------+--------------------+---------+----------+-----------+%n");
        System.out.format("| ProjectId | fullName           | Role    |   idEmp  | expInYear |%n");
        System.out.format("+-----------+--------------------+---------+----------+-----------+%n");
        for (int i = 0; i < managerList.size(); i++) {
            Manager mn = managerList.get(i);
            System.out.format(leftAlignFormat, mn.getProjectManageId(),
                    mn.getFullName(), mn.getRole().toString(), mn.getId(), mn.getExpInYear());
        }
        System.out.format("+-----------+--------------------+---------+----------+-----------+%n");
    }
}
