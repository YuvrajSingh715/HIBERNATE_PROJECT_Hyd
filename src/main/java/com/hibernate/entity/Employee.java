package com.hibernate.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "employee_details")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "emp_name")
	private String Name;

	@Column(length = 35, name = "emp_address")
	private String fullAddress;

	private double salary;
	
	private String companyName;
	
	@Transient
	private String hrMail;
	
	@Column(name = "emp_joiningDate")
	private LocalDate joiningDate;
	
	@Column(name = "project_Submission")
	private LocalTime projectSubmissionTime;
	
	@Column(name = "assignOn")
	private LocalDateTime projectAssignmentZone;

	@Lob
	private byte[] projectImage;
}
