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
        System.out.println("Manager List With Role " + Role.MANAGER);
        String leftAlignFormat = "| %-9d | %-18s | %-7s | %-8d | %-9d |%n";
        System.out.format("+-----------+--------------------+---------+----------+-----------+%n");
        System.out.format("| ProjectId | fullName           | Role    |   idEmp  | expInYear |%n");
        System.out.format("+-----------+--------------------+---------+----------+-----------+%n");
        managerList.forEach(x ->
                System.out.format(leftAlignFormat, x.getProjectManageId(),
                        x.getFullName(), x.getRole().toString(), x.getId(), x.getExpInYear())
        );
        System.out.format("+-----------+--------------------+---------+----------+-----------+%n");
    }
}
