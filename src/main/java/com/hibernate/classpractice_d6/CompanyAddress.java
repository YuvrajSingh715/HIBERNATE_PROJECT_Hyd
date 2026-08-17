package com.hibernate.classpractice_d6;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Embeddable
public class CompanyAddress {

	@Column(name = "cmp_name")
	private String name;

	@Column(name = "cmp_street")
	private String street;

	@Column(name = "cmp_location")
	private String location;

}
