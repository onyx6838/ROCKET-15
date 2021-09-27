package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Short> , JpaSpecificationExecutor<Department> {
    Department findByNameIgnoreCase(String name);

    boolean existsByName(String name);

    @Modifying    // custom query
    @Transactional    // delete nhie`u can  transaction
    @Query("DELETE FROM Department WHERE id IN(:ids)")    // hql param tren java
    void deleteByIds(@Param("ids") List<Short> ids);
}
