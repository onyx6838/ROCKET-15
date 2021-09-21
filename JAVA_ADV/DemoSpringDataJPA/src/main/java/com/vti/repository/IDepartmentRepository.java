package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Short> , JpaSpecificationExecutor<Department> {
    Department findByNameIgnoreCase(String name);

    boolean existsByName(String name);
}
