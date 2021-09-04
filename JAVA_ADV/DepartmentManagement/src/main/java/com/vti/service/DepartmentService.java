package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentByID(short id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	@Override
	public void createDepartment(DepartmentFormForCreating form) {
		// convert form --> entity

		// get author (jpa hoat dong tren object)
		Account author = accountRepository.findById(form.getAuthorId()).get();

		Department department = new Department(form.getName());
		department.setAuthor(author);

		departmentRepository.save(department);
	}

	@Override
	public void updateDepartment(short id, DepartmentFormForUpdating form) {
		Department department = getDepartmentByID(id);
		department.setName(form.getName());

		departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(short id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public boolean isDepartmentExistsByID(short id) {
		return departmentRepository.existsById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		return departmentRepository.existsByName(name);
	}

	@Override
	public void deleteDepartments(List<Short> ids) {
		departmentRepository.deleteByIds(ids);
	}
}
