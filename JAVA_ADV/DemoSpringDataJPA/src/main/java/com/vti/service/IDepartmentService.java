package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {

    List<Department> getAllDepartments(Pageable pageable);

    Department getDepartmentByID(short id);

    Department getDepartmentByName(String name);

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(short id);

    boolean isDepartmentExistsByID(short id);

    boolean isDepartmentExistsByName(String name);
}
