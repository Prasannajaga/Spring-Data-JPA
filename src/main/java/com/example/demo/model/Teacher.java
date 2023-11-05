package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_teacher") 
@Builder
public class Teacher {
	
	@Id
	@SequenceGenerator(
			name = "teacher_sequence" , allocationSize = 1
	)
	@GeneratedValue(generator = "teacher_sequence" , strategy = GenerationType.SEQUENCE)
	private Long teacherId;
	private String firstName;
	private String lastName;
 
	
//	@OneToMany(cascade =  CascadeType.ALL)
//	@JoinColumn(
//			name = "teacher_id",
//			referencedColumnName = "teacherId"
//	)
//	private List<Course> courses;
	

}
