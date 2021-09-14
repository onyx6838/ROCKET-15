package com.vti.test;

import java.util.List;

import com.vti.entity.Address;
import com.vti.entity.DetailDepartment;
import com.vti.repository.AddressRepository;
import com.vti.repository.DetailDepartmentRepository;

public class DetailDepartmentTest {
	public static void main(String[] args) {
		DetailDepartmentRepository repository = new DetailDepartmentRepository();
		AddressRepository addressRepository = new AddressRepository();

		System.out.println("***********GET ALL***********");

		List<DetailDepartment> DetailDepartments = repository.getAllDetailDepartments();

		for (DetailDepartment detailDepartment : DetailDepartments) {
			System.out.println(detailDepartment);
		}

		System.out.println("\n\n***********CREATE***********");

		DetailDepartment detailDepartmentCreate = new DetailDepartment();

		// get address by id
		Address address = addressRepository.getAddressByID((short) 1);
		// Address address = new Address("P702");

		detailDepartmentCreate.setAddress(address);
		detailDepartmentCreate.setName("Phong Moi Tao");
		detailDepartmentCreate.setEmulationPoint((short) 7);

		repository.createDepartment(detailDepartmentCreate);

	}
}
