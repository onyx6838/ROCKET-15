package com.vti.service;

import java.util.List;

import com.vti.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGroupService {

    Page<Group> getAllGroups(Pageable pageable);

    Group getGroupByID(int id);

    Group getGroupByName(String name);

    void deleteGroup(int id);

    boolean isGroupExistsByID(int id);

    boolean isGroupExistsByName(String name);

    void deleteGroups(List<Integer> ids);
}
