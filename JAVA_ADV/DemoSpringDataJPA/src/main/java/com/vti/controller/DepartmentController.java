package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping()
    public ResponseEntity<?> getAllDepartments(Pageable pageable) {
        Page<Department> entities = service.getAllDepartments(pageable);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(service.getDepartmentByID(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto) {
        service.createDepartment(dto.toEntity());
        return new ResponseEntity<>("Create successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO dto) {
        Department department = dto.toEntity();
        department.setId(id);
        service.updateDepartment(department);
        return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
        service.deleteDepartment(id);
        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
    }
}
