
package com.example.demo.model;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "tbl_course_Material")
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(
	name = "course_id_sequence", 
	allocationSize = 1
	)
	@GeneratedValue(
	generator = "course_id_sequence", strategy = GenerationType.SEQUENCE
	)
 	private String courseMaterialId;
 	private String url;
	@OneToOne
	@JoinColumn(
			name  = "course_id" , referencedColumnName  = "courseId"
	)
	private Course course;

}
