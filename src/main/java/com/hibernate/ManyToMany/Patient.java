package com.hibernate.ManyToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "patient")
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private int id;

	@Column(name = "patient_name")
	private String name;

	@ManyToMany
	@ToString.Exclude
	@JoinTable(name = "doctor_patient", 
	joinColumns = @JoinColumn(name = "patient_id"), 
	inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private List<Doctor> doctor;

}
