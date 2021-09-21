package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments(Pageable pageable) {
		return (List<Department>) repository.findAll(pageable);
	}
}
