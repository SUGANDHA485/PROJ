package com.lti.ui;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main1 {

	public static void main(String[] args) {
		// Constructor Injection
		Student student3 = new Student(1, "Jack", 70);
		
		// Setter Injection
		Address address = new Address();
		address.setAddressId(10);
		address.setCity("Mumbai");
		address.setPin(410210);
		
		student3.setAddress(address);
		
		System.out.println(address);
		System.out.println(student3);
		System.out.println(student3.getAddress());
	}
}
