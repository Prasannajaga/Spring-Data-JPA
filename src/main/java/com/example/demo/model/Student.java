package com.example.demo.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name ="tbl_student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@UuidGenerator
	@Column(name = "student_Id")
	private String studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_email")
	private String studentEmail;
	@Column(name = "student_age")
	private Integer age;
	@Embedded
	private Guardian guardian;
	
}
