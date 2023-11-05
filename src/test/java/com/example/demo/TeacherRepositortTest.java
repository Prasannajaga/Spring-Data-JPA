package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customTemplate.CriteriaTemplate;
import com.example.demo.model.Course;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@SpringBootTest
public class TeacherRepositortTest {

	@Autowired
	private TeacherRepository repository;
	
	@Autowired
	private EntityManager manager;
	
//	@Test
//	public void saveTeacher() {
//		
//		Course course = Course.builder().
//						courseTitle("RUBY").credits(100).
//						build();
//		
//		Course course2 = Course.builder().
//				courseTitle("PYTHON").credits(200).
//				build();
//		
//		Course course3 = Course.builder().
//				courseTitle("JAVA").credits(1000).
//				build();
//		
//		Teacher teacher =  Teacher.builder().
////							teacherId("1002).
//							firstName("Prasanna")
//							.lastName("jaga").
////							.courses(List.of(course,course2,course3)).
//							build();
//		
//		Teacher n  = repository.save(teacher);
//		System.err.println(n);
//		
//	}
	
	
	@Test
	@Transactional() 
	public void getAllTeacher() {
		CriteriaTemplate<Teacher> template = new CriteriaTemplate<Teacher>(manager, Teacher.class);
		List<Teacher> teacher = template.customQuery("SELECT * FROM tbl_teacher");
		teacher.forEach(System.out::println);
	}
	
	
}
