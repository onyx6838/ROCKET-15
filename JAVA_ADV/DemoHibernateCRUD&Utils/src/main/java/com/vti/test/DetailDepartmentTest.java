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

		System.out.println("***********GET ALL ***********");

		List<DetailDepartment> departments = repository.getAllDetailDepartments();

		for (DetailDepartment department : departments) {
			System.out.println(department);
		}

		System.out.println("\n\n***********CREATE ***********");

		DetailDepartment testCreate = new DetailDepartment();
		
		// get address by id
		Address new1 = addressRepository.getAddressById((short) 1);	// update 
		//Address new1  = new Address("P702");	// k co address thi se create khi save lquan foreign
		
		testCreate.setAddress(new1);
		testCreate.setName("Phong Moi Tao");
		testCreate.setEmulationPoint((short) 8);
		repository.createDepartment(testCreate);
	}
}
