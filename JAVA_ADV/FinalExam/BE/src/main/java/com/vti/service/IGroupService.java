package com.vti.service;

import com.vti.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {

    Page<Group> getAllGroups(Pageable pageable);

    Group getGroupByID(int id);

    Group getGroupByName(String name);

    void createGroup(Group group);

    void updateGroup(int id, Group group);

    void deleteGroup(int id);

    boolean isGroupExistsByID(int id);

    boolean isGroupExistsByName(String name);

    void deleteGroups(List<Integer> ids);
}
