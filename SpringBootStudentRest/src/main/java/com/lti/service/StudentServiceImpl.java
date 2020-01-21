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
		dao.beginTransaction();
		int result= dao.createStudent(student);
		dao.commitTransaction();
		if(result==1)
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
		Student result=dao.readStudentByRollNumber(rollNumber);
		return result;
	}
	
	@Override
	public int updateStudent(Student student) {
		dao.beginTransaction();
		int result = dao.updateStudent(student);
		dao.commitTransaction();
		return result;
	}
	
	@Override
	public int deleteStudent(int rollNumber) {
		dao.beginTransaction();
		int result = dao.deleteStudent(rollNumber);
		dao.commitTransaction();
		return result;
	}
	
	public List<Student> viewAllStudents(){
		return dao.viewAllStudents();
	} 

}
