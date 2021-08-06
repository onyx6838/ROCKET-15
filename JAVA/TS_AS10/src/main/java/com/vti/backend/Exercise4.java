package com.vti.backend;

import com.vti.utils.JdbcUtils;
import com.vti.dao.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Exercise4 {
    private DepartmentDao departmentDao;
    private AccountDao accountDao;

    public Exercise4() {
        departmentDao = new DepartmentDao();
        accountDao = new AccountDao();
    }

    public void Ques1() throws SQLException, IOException {
        Connection connection = JdbcUtils.getInstance().connect();
        connection.setAutoCommit(false);
        try {
            accountDao.deleteAccountByDepartmentId(3);
            departmentDao.deleteDepartment(3);
            connection.commit();
            System.out.println("Transac commit");
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Rollback");
        }

        connection.setAutoCommit(true);
        JdbcUtils.getInstance().disconnect();
    }
}
