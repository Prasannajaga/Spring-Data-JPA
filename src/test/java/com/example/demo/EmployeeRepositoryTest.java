package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void saveEmployee() {
		
		Employee employee = Employee.builder().employeeEmail("prasa@asa.com").employeeName("PRASANNA").
				build(); 
		repository.save(employee);
		
	}
}
