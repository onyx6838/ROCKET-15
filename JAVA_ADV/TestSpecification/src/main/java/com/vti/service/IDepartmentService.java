package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments(Pageable pageable);
}
