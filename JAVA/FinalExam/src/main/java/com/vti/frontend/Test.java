package com.vti.frontend;

import com.vti.frontend.function.ProjectFunction;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, IOException {
        ProjectFunction projectFunction = new ProjectFunction();
        projectFunction.getProjectById();
    }
}
