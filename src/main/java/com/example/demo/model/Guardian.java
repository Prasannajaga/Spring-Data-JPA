package com.example.demo.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
	@AttributeOverride(
	name = "name" , column = @Column(name = "guardian_name")),
	@AttributeOverride(
			name = "email" , column = @Column(name = "guardian_email")),
	@AttributeOverride(
			name = "address" , column = @Column(name = "guardian_address"))
})
public class Guardian {

	private String name;
	private String email;
	private String address;
	
}
