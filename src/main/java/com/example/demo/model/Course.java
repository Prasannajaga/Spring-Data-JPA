package com.example.demo.model;

 import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Builder
@Entity
@ToString(exclude = "teacher")
@Table(name = "tbl_course")
public class Course {
	
	@Id
	@SequenceGenerator(
	name = "course_id_sequence", 
	sequenceName = "course_id_sequence",
	allocationSize = 1
	)
	@GeneratedValue(
	generator = "course_id_sequence", strategy = GenerationType.SEQUENCE
	)
 	private Long courseId;
 	private String courseTitle;
 	private Integer credits;
 	
 	@OneToOne(mappedBy = "course")
 	private CourseMaterial courseMaterial;
 	
 	@ManyToOne(cascade = CascadeType.ALL)
 	@JoinColumn(
 			name = "teacher_Id" , referencedColumnName = "teacherId"
 	)
 	private Teacher teacher;

}
