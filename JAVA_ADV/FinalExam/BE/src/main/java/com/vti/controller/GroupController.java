package com.vti.controller;

import com.vti.dto.AccountDto;
import com.vti.dto.GroupDto;
import com.vti.entity.Group;
import com.vti.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin("*")
public class GroupController {
    @Autowired
    private IGroupService service;

    @GetMapping()
    public ResponseEntity<Page<GroupDto>> getAllDepartments(Pageable pageable) {
        Page<Group> entitiesPage = service.getAllGroups(pageable);
        Page<GroupDto> dtoPage = entitiesPage
                .map(entity -> new GroupDto(
                        entity.getId(),
                        entity.getName(),
                        new AccountDto(entity.getCreator().getId(), entity.getCreator().getFullName()),
                        entity.getMember(),
                        entity.getCreateDate()));
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GroupDto> getGroupByID(@PathVariable(name = "id") short id) {

        Group entity = service.getGroupByID(id);

        GroupDto dto = new GroupDto(entity.getId(),
                entity.getName(),
                new AccountDto(entity.getCreator().getId(), entity.getCreator().getFullName()),
                entity.getMember(),
                entity.getCreateDate());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}/exists")
    public ResponseEntity<Boolean> existsByName(@PathVariable(name = "name") String name) {
        return new ResponseEntity<>(service.isGroupExistsByName(name), HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<String> createGroup(@RequestBody GroupFormForCreating form) {
//        service.createGroup(form);
//        return new ResponseEntity<>("Create successfully!", HttpStatus.CREATED);
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<String> updateGroup(@PathVariable(name = "id") short id,
//                                              @RequestBody GroupFormForUpdating form) {
//        service.updateGroup(id, form);
//        return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<String> deleteGroup(@PathVariable(name = "id") short id) {
//        service.deleteGroup(id);
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
//    }
//
//    @DeleteMapping
//    public ResponseEntity<String> deleteGroups(@RequestParam(name = "ids") List<Short> ids) {
//        service.deleteGroups(ids);
//        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
//    }
}
