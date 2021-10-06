package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.form.GroupFilterForm;
import com.vti.form.GroupFormForCreating;
import com.vti.repository.IGroupRepository;
import com.vti.specification.GroupSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private IAccountService accountService;

    @Override
    public Page<Group> getAllGroups(Pageable pageable, String search, GroupFilterForm filter) {
        Specification<Group> where = null;

        if (!ObjectUtils.isEmpty(search)) {
            GroupSpecification nameSpecification = new GroupSpecification("name", "LIKE",
                    search);
            GroupSpecification authorSpecification = new GroupSpecification("creator.fullName", "LIKE", search);
            where = Specification.where(nameSpecification).or(authorSpecification);
        }

        if (filter != null && filter.getMinDate() != null) {
            GroupSpecification minDateSpecification = new GroupSpecification("createDate", ">=",
                    filter.getMinDate());
            if (where == null) {  // chua co search chi? filter
                where = Specification.where(minDateSpecification);
            } else {
                where = where.and(minDateSpecification);
            }
        }

        if (filter != null && filter.getMaxDate() != null) {
            GroupSpecification maxDateSpecification = new GroupSpecification("createDate", "<=",
                    filter.getMaxDate());
            if (where == null) {
                where = Specification.where(maxDateSpecification);
            } else {
                where = where.and(maxDateSpecification);
            }
        }
        return groupRepository.findAll(where, pageable);
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
    public void createGroup(GroupFormForCreating form) {
        Group gr = new Group();
        Account account = accountService.findById(form.getCreatorId());
        gr.setName(form.getName());
        gr.setCreator(account);
        groupRepository.save(gr);
    }

    @Override
    public void updateGroup(int id, Group group) {
        Group groupRequest = getGroupByID(id);
        groupRequest.setName(group.getName());
        groupRepository.save(groupRequest);
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
