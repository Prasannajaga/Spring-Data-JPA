package com.example.demo;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customTemplate.CriteriaTemplate;
import com.example.demo.customTemplate.PostgreSqlTemplate; 
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
  	private EntityManager manager;
	
//	@Test
//	void saveStudent() {
//	Guardian guar = Guardian.builder()
//			.name("SELVI")
//			.address("PDK")
//			.email("selvi@asa.com")
//			.build();
//	
//	Student student = Student.builder()
//			.studentName("Kumar")
//			.age(16)
//			.studentEmail("kumar@asa.com")
//			.guardian(guar)
//			.build();
//	
//	studentRepo.save(student); 
//	
//	}
//	
//	@Test
//	void updateStudent() {
//		Student stu = studentRepo.findByStudentName("jagadesh");
//		stu.setAge(14);
//		studentRepo.save(stu);
//	}
//	
//	@Test
//	void findGreaterThan() {
//		List<Student> student = studentRepo.findByAgeGreaterThan(19);
//		System.err.println("RESUlT" + student);
//	}
//	
//	@Test
//	void QueryNameAndEmail() {
//		Student student = studentRepo.getNameandEmail("prasanna" ,"prasa@asa.com");
// 		System.err.println("RESULTS ->" + student);
//		
//	}
//	
//	@Test
//	public void updateStudentName() { 
//		int student = studentRepo.updateNameByEmail("Tejus Kumar", "kumar@asa.com");
//		System.err.println("RESULTS ->>" + student);
//	}
//	
//	@Test
//	void findAges() {
//	List<Integer> ages = Lists.newArrayList(14,16);
//	List<Student> n = studentRepo.findByAgeBetween(10 , 16);
//	System.err.println("RSULT ->" + n);
//	}
	
	@Test
	public void findByStudentName() {
		CriteriaTemplate<Student> query = new CriteriaTemplate<Student>(manager, Student.class);
		List<Student> n = query.<Integer>findByPropertyNameIn("studentAge", List.of(16 , 14));
		System.err.println("RESULTS ->>" + n);
	}
	
//	@Test
//	void getByName(){
//		List<Student> students = studentRepo.findByStudentNameIsNot("prasanna");
//		System.out.println("STUDENTS" + students);
//	}

}
