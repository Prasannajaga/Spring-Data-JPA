package com.example.demo.model;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_course")
public class Course {
	
	@Id
	@SequenceGenerator(
	name = "course_id_sequence", 
	allocationSize = 1
	)
	@GeneratedValue(
	generator = "course_id_sequence", strategy = GenerationType.SEQUENCE
	)
 	private String courseId;
 	private String courseTitle;
 	private Integer credits;

}
