package com.vti.frontend.function;

import com.vti.backend.presentationlayer.ProjectController;
import com.vti.entity.Project;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectFunction {
    private ProjectController controller;

    public ProjectFunction() throws SQLException, IOException {
        controller = new ProjectController();
    }

    public void getProjectById() throws SQLException {
        System.out.println("Nhập vào id project muốn tìm");
        int id = (int) ScannerUtils.getInstance().inputPreventPositive("Đúng định dạng và > 0", Integer.class);
        Project proj = controller.getProjectById(id);
        System.out.println("Project Detail With ID " + id);
        String leftAlignFormat = "| %-9d | %-18s | %-7s | %-9d |%n";
        System.out.format("+-----------+--------------------+----------+----------+%n");
        System.out.format("| ProjectId | fullName           | Role     |   idEmp  |%n");
        System.out.format("+-----------+--------------------+----------+----------+%n");
        for (int i = 0; i < proj.getParticipants().size(); i++) {
            User us = proj.getParticipants().get(i);
            System.out.format(leftAlignFormat, proj.getProjectId(), us.getFullName()
                    , us.getRole().toString(), us.getId());
        }
        System.out.format("+-----------+--------------------+----------+----------+%n");
    }
}
