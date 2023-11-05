package com.example.demo.model;
 
 
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.example.demo.genericGenerator.StringPrefixedSequenceIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(generator = "sequence-generator" , strategy = GenerationType.SEQUENCE) 
	@GenericGenerator(
			name  = "sequence-generator" , strategy = "com.example.demo.genericGenerator.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value= "50"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value= "ATS_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value= "%010d"), 
			}
	)
	@Column(name = "employee_Id" , updatable = false , nullable = false)
	private String employeeId;
	private String employeeName;
	private String employeeEmail;

}
