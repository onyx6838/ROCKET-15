package com.vti.controller;

import com.vti.dto.AccountDto;
import com.vti.dto.DetailGroupDto;
import com.vti.dto.GroupDto;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFormForUpdating;
import com.vti.service.IAccountService;
import com.vti.service.IGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin("*")
public class GroupController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IAccountService accountService;

    @GetMapping()
    public ResponseEntity<Page<GroupDto>> getAllDepartments(Pageable pageable) {
        Page<Group> entitiesPage = groupService.getAllGroups(pageable);
        Page<GroupDto> dtoPage = entitiesPage
                .map(entity -> {
                    AccountDto account = modelMapper.map(entity.getCreator(), AccountDto.class);
                    GroupDto group = modelMapper.map(entity, GroupDto.class);
                    group.setCreator(account);
                    return group;
                });
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetailGroupDto> getGroupByID(@PathVariable(name = "id") int id) {
        Group entity = groupService.getGroupByID(id);
        // convert
        AccountDto account = modelMapper.map(entity.getCreator(), AccountDto.class);
        DetailGroupDto group = modelMapper.map(entity, DetailGroupDto.class);
        group.setCreator(account);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}/exists")
    public ResponseEntity<Boolean> existsByName(@PathVariable(name = "name") String name) {
        return new ResponseEntity<>(groupService.isGroupExistsByName(name), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createGroup(@Valid @RequestBody GroupFormForCreating form) {
        Group group = modelMapper.map(form, Group.class);
        Account account = accountService.findById(form.getCreatorId());
        group.setCreator(account);
        groupService.createGroup(group);
        return new ResponseEntity<>("Create successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateGroup(@PathVariable(name = "id") short id,
                                              @RequestBody GroupFormForUpdating form) {
        Group group = modelMapper.map(form, Group.class);
        groupService.updateGroup(id, group);
        return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable(name = "id") short id) {
        groupService.deleteGroup(id);
        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGroups(@RequestParam(name = "ids") List<Integer> ids) {
        groupService.deleteGroups(ids);
        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
    }
}
