package com.vti.repository;

import java.util.List;

import com.vti.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface IGroupRepository extends JpaRepository<Group, Integer>, JpaSpecificationExecutor<Group> {

    Group findByName(String name);

    boolean existsByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Group WHERE id IN(:ids)")
    void deleteByIds(@Param("ids") List<Integer> ids);
}
