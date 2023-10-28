package com.example.demo.model;

 
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity
@Table(name = "tbl_Main")
public class Main {

	@Id
	@UuidGenerator
 	private String userId;
	private String userName;
	private String userEmail;
}
