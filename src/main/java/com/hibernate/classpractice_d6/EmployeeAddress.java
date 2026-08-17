package com.hibernate.classpractice_d6;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Embeddable
public class EmployeeAddress {

	@Column(name = "emp_street")
	private String street;

	@Column(name = "emp_location")
	private String location;

}
