package com.vti.service;

import com.vti.entity.Group;
import com.vti.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService{
    @Autowired
    private IGroupRepository groupRepository;

    @Override
    public Page<Group> getAllGroups(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public Group getGroupByID(int id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Group getGroupByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public void deleteGroup(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public boolean isGroupExistsByID(int id) {
        return groupRepository.existsById(id);
    }

    @Override
    public boolean isGroupExistsByName(String name) {
        return groupRepository.existsByName(name);
    }

    @Override
    public void deleteGroups(List<Integer> ids) {
        groupRepository.deleteByIds(ids);
    }
}
