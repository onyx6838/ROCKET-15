package com.vti.service;

import com.vti.entity.Group;
import com.vti.form.GroupFilterForm;
import com.vti.form.GroupFormForCreating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface IGroupService {

    Page<Group> getAllGroups(Pageable pageable, String search, GroupFilterForm filter);

    Group getGroupByID(int id);

    Group getGroupByName(String name);

    void createGroup(GroupFormForCreating form);

    void updateGroup(int id, Group group);

    void deleteGroup(int id);

    boolean isGroupExistsByID(int id);

    boolean isGroupExistsByName(String name);

    void deleteGroups(List<Integer> ids);
}
