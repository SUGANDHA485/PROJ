package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;

@Repository("dao")
public class StudentDaoImpl implements StudentDao {
	private EntityManager entityManager;
	
	public StudentDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}
	
	@Override
	public int createStudent(Student student) {
		entityManager.persist(student);
		return 1;
	}

	@Override
	public Student readStudentByRollNumber(int rollNumber) {
		String jpql = "SELECT s From Student s WHERE s.rollNumber = :rollno";
		TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
		query.setParameter("rollno", rollNumber);
		return query.getSingleResult();
	}

	@Override
	public int updateStudent(Student student) {
		String jpql = "UPDATE Student  SET studentName = :name, studentScore = :score WHERE rollNumber = :rollno";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("name", student.getStudentName());
		query.setParameter("score", student.getStudentScore());
		query.setParameter("rollno", student.getRollNumber());
		return query.executeUpdate();
	}

	@Override
	public int deleteStudent(int rollNumber) {
		String jpql = "DELETE FROM Student WHERE rollNumber = :rollno";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("rollno", rollNumber);
		return query.executeUpdate();
	}

	@Override
	public List<Student> viewAllStudents() {
		String jpql = "FROM Student ORDER BY rollNumber";
		TypedQuery<Student> query = entityManager.createQuery(jpql,Student.class);
		return query.getResultList();
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

}
