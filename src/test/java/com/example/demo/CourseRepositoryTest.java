package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customTemplate.CriteriaTemplate;
import com.example.demo.model.Course;
import com.example.demo.model.CourseMaterial;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseMaterialRepository;
import com.example.demo.repository.CourseRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	 
	
	@Test
	public void saveCourseMaterialAndCourse() {
		Course course = Course.builder()
						 .courseTitle("Java")
						 .credits(10)
						.build();
		
		CourseMaterial material =  CourseMaterial.builder().course(course).url("Click here!").build();
		
		courseMaterialRepository.save(material);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("Kumar").lastName("Kumar").build();
		
		Course course = Course.builder()
				 .courseTitle("JAVA")
				 .credits(1000).teacher(teacher)
				 .build();	
		courseRepository.save(course);
	}
	
	@Test
	@Transactional
	public void getAllCouse() {
		List<Course> courses = courseRepository.findAll();
		System.err.println("COURSESS  " + courses );
	}
	
	@Test
	public void GetAllMAterial() {
		CriteriaTemplate<Course> material = new CriteriaTemplate<Course>(manager, Course.class);
		List<Course> materials = material.findAll();
		
		System.err.println("RESULTS" + materials);
	}
	
	
	

}
