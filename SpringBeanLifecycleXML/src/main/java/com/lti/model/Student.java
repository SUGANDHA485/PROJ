package com.lti.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	private int rollNumber;
	private String studentName;
	private double studentScore;
	
	
	private Address address;

	public Student() {
		System.out.println(" ----- Student() -----");
	}
	public Student(Address address)
	{
				this.address=address;
	}
	
	public Student(int rollNumber, String studentName, double studentScore) {
		super();
		System.out.println(" ----- Student(-,-,-) -----");
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", studentScore=" + studentScore+ "]";
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(double studentScore) {
		this.studentScore = studentScore;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Spring bean ready to use.");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Spring bean is about to be deleted.");
		
	}
	

	public void onInit() throws Exception {
		System.out.println("Custom Init called.");
		
	}

	public void onDestroy() throws Exception {
		System.out.println("Custom Destroy called.");
		
	}
	
	@PostConstruct
	public void postConstruct() throws Exception {
		System.out.println("Annotation Init called.");
		
	}
	
	@PreDestroy
	public void preDestroy() throws Exception {
		System.out.println("Annotation Destroy called.");
		
	}
	
	
	
		
}
