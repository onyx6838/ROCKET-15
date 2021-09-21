package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping()
    public ResponseEntity<?> getAllDepartments(Pageable pageable, @RequestParam(required = false) String search,
                                               DepartmentFilterForm filter) {
        List<Department> entities = service.getAllDepartments(pageable);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

}
