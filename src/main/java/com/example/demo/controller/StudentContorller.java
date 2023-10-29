package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customTemplate.CriteriaTemplate;
import com.example.demo.model.Student;

import jakarta.persistence.EntityManager;

@RestController
public class StudentContorller extends BaseController<Student>{

	@Autowired
	private EntityManager manager;
	
	@Override
	public Student save(Student data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student update(Student data) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/findAllStudent")
	@Override
	public List<Student> findAll() {
		CriteriaTemplate<Student> query = new CriteriaTemplate<Student>(manager, Student.class);
		return query.findAll();
	}

	@GetMapping("/findByStudentName")
	@Override
	public Student findById(String id) {
		CriteriaTemplate<Student> query = new CriteriaTemplate<Student>(manager, Student.class);
		return null;
	}
	
	@GetMapping("/findByStudentName/{id}") 
	public List<Student> findByEmail(@PathVariable String id) {
		CriteriaTemplate<Student> query = new CriteriaTemplate<Student>(manager, Student.class);
		return query.findByEqaulsPropertyName("studentEmail", id);
	}
	
	@GetMapping("/findByIn")
	public List<Student> findByIn(){
		CriteriaTemplate<Student> query = new CriteriaTemplate<Student>(manager, Student.class);
		List<Student> n = query.<Integer>findByPropertyNameIn("age", List.of(16 , 14));
		return n;
	}
	 

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
