package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Student;
import com.lti.service.StudentService;


@RestController
@RequestMapping("/")
@CrossOrigin
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	// http://localhost:9090/
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findAllStudents(){
		return service.viewAllStudents();		
	}
	
	// http://localhost:9090/'parameter'
	@RequestMapping(path= "{rollno}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Student findStudentByRollNumber(@PathVariable("rollno") int rollNumber){
		return service.FindByRollNumber(rollNumber);
	}
	
	// http://localhost:9090/delete/{rollno}
	@RequestMapping(path= "/delete/{rollno}", method = RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public void deleteStudent(@PathVariable("rollno") int rollNumber){
		service.deleteStudent(rollNumber);
	}
	
	/*// http://localhost:9090/add/{rollno}/{name}/{score}
	@RequestMapping(path= "/add/{rollno}/{name}/{score}", method = RequestMethod.POST, produces=MediaType.ALL_VALUE)
	public String addStudent(@PathVariable("rollno") int rollNumber, @PathVariable("name") String name,
			@PathVariable("score") double score){
		Student student = new Student(rollNumber, name, score);
		if(service.addStudent(student))	
			return "Student Added :)";
		else
			return "Could not add the Student :(";
	}*/
	
	// http://localhost:9090/
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student){
		service.addStudent(student);
	}
	
	// http://localhost:9090/update
	@RequestMapping(path ="/update", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student){
		service.updateStudent(student);
	}
}
