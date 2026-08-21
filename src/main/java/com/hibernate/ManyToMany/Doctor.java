package com.hibernate.ManyToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private int id;
	
	@Column(name = "doctor_name")
	private String name;
	
	@ManyToMany(mappedBy = "doctor" ,cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Patient> patient;

}
