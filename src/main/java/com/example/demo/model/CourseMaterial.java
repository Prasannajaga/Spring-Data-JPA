
package com.example.demo.model;

 import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "tbl_course_Material")
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(
	name = "course_material_id_sequence", 
	sequenceName = "course_material_id_sequence",
	allocationSize = 1
	)
	@GeneratedValue(
	generator = "course_material_id_sequence", strategy = GenerationType.SEQUENCE
	)
 	private Long courseMaterialId;
 	private String url;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name  = "course_id" , referencedColumnName  = "courseId"
	)
	private Course course;

}
