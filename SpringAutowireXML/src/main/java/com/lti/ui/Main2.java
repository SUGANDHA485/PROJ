package com.lti.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		Student student1 = (Student) context.getBean("student");
		Student student2 = (Student) context.getBean("student");
		
		/*System.out.println("\n------ Before ------");*/
		System.out.println(student1+"\n"+student1.getAddress());
		System.out.println(student2+"\n"+student2.getAddress());
		
		student2.setStudentName("Rose");
		
		/*System.out.println("\n------ After ------");*/
		System.out.println(student1+"\n"+student1.getAddress());
		System.out.println(student2+"\n"+student2.getAddress());
		
		/*Address address = (Address) context.getBean("address");
		System.out.println(address.getCity());
		*/
	}
}
