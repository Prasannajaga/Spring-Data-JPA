package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends BaseRepository<Student, String> {

	
	List<Student> findByStudentNameEquals(String name);
	
	Student findByStudentName(String name); 
	
	List<Student> findByAgeIn(List<Integer> ages);
	
	List<Student> findByAgeBetween(Integer startAge , Integer endAge);
	
	List<Student> findByAgeGreaterThan(int age);
	
	// JPQL
	@Query(value  = "SELECT * from tbl_student ts WHERE ts.student_email = ?1" , nativeQuery = true)
	Student getByEmail(String email);
	
	// Native Query
	@Query(value = "SELECT * FROM tbl_student s WHERE s.student_name = ?1 AND s.student_email = ?2" , nativeQuery = true)
	Student getNameandEmail(String name , String email);
	
	
	// Native Query with Parameters
	@Query(value = "SELECT * FROM tbl_student s WHERE s.student_name = :name AND s.student_email = :email" , nativeQuery = true)
	Student getEmailAndName(@Param("name") String name ,@Param("email") String email);

	
	@Modifying
	@Transactional
	@Query(
		value = "UPDATE tbl_student SET student_name = ?1 WHERE student_email = ?2"
		, nativeQuery = true
	)
	int updateNameByEmail(String name , String email);
	
	
	List<Student> findByStudentNameIsNot(String name);

}
