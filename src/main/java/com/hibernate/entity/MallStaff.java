package com.hibernate.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Embeddable
public class MallStaff {

	private String staffName;
	private String gender;
	private double salary;

}
