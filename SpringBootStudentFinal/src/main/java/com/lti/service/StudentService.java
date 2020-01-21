package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
public boolean  addStudent(Student student); 
public Student FindByRollNumber(int rollNumber);
public int updateStudent(Student student);
public int deleteStudent(int rollNumber);
public List<Student> viewAllStudents();
}
