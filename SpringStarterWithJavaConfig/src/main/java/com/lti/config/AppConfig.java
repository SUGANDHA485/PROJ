package com.lti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lti.model.Address;
import com.lti.model.Student;

@Configuration
public class AppConfig {
	@Bean(name="student")
	public Student getStudent(){
		Student student=new Student(1, "Jack", 87);
		student.setAddress(getAddress());
		return student;
	}
	
	@Bean(name="address")
	public Address getAddress(){
		Address address = new Address(10, "Mumbai", 1234);
		return address;
	}
}
