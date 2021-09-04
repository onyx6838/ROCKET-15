package com.vti.test;

import java.util.List;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;

public class AddressTest {
	public static void main(String[] args) {
		AddressRepository repository = new AddressRepository();

		System.out.println("***********GET ALL***********");

		List<Address> addresses = repository.getAllAdresses();

		for (Address address : addresses) {
			System.out.println(address);
			System.out.println(address.getDepartment().getName().toString());
		}

	}
}
