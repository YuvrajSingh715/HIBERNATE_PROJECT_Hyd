package com.hibernate.mcq_platform;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Answers")
@Data
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ans_id")
	private int id;

	private String answer;

}
