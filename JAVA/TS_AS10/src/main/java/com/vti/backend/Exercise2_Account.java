package com.vti.backend;

import com.vti.dao.*;
import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Exercise2_Account {
    private DepartmentDao dao;

    public Exercise2_Account() {
        dao = new DepartmentDao();
    }

    public void Ques1() throws SQLException, IOException {
        List<Department> departmentList = dao.getDepartments();
        departmentList.forEach(System.out::println);
    }

    public void Ques2() throws SQLException, IOException {
        Department department = dao.getDepartmentById(5);
        System.out.println(department);
    }

    public void Ques3() throws SQLException, IOException {
        int id = (int) ScannerUtils.getInstance().inputPreventPositive("Int and > 0", Integer.class);
        Department department = dao.getDepartmentById(id);
        System.out.println(department);
    }

    public void Ques4() throws SQLException, IOException {
        String name = ScannerUtils.getInstance().inputString("Not empty");
        System.out.println(dao.isDepartmentNameExists(name) ? "Exist" : "Not Exist");
    }

    public void Ques5() throws SQLException, IOException {
        String name = ScannerUtils.getInstance().inputString("Not empty");
        if (dao.isDepartmentNameExists(name))
            throw new SQLException("Depart name is exist");
        else
            dao.createDepartment(name);
    }

    public void Ques6() throws SQLException, IOException {
        String name = ScannerUtils.getInstance().inputString("Not empty");
        int idUpdate = (int) ScannerUtils.getInstance().inputPreventPositive("Int and > 0", Integer.class);
        if (dao.getDepartmentById(idUpdate) == null)
            throw new SQLException("Cannot find department which has id = " + idUpdate);
        else {
            if (dao.isDepartmentNameExists(name))
                throw new SQLException("Depart name is exist");
            else
                dao.updateDepartmentName(idUpdate, name);
        }
    }

    public void Ques7() throws SQLException, IOException {
        int idDel = (int) ScannerUtils.getInstance().inputPreventPositive("Int and > 0", Integer.class);
        if (dao.getDepartmentById(idDel) == null)
            throw new SQLException("Cannot find department which has id = " + idDel);
        else {
            dao.deleteDepartment(idDel);
        }
    }
}