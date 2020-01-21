package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.StudentDao;
import com.lti.model.Student;

@Service("service")
@Scope(scopeName="singleton")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;
	
	@Override
	public boolean addStudent(Student student) {	
		if(dao.createStudent(student)==1)
			return true;
		else 
			return false;
	}
	
	public StudentDao getDao() {
		return dao;
	}
	
	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Student FindByRollNumber(int rollNumber) {
		return dao.readStudentByRollNumber(rollNumber);
	}
	
	@Override
	public int updateStudent(Student student) {
		return dao.updateStudent(student);
	}
	
	@Override
	public int deleteStudent(int rollNumber) {
		return dao.deleteStudent(rollNumber);
	}
	
	public List<Student> viewAllStudents(){
		return dao.viewAllStudents();
	} 

}
