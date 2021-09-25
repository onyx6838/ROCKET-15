package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {

    Page<Department> getAllDepartments(Pageable pageable);

    Department getDepartmentByID(short id);

    Department getDepartmentByName(String name);

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(short id);

    boolean isDepartmentExistsByID(short id);

    boolean isDepartmentExistsByName(String name);
}
