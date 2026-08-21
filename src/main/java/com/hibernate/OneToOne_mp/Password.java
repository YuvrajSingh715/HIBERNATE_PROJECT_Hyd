package com.hibernate.OneToOne_mp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "password")
@Data
public class Password {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "password_id")
	private int id;

	private String password;

//	@OneToOne
	@OneToOne(mappedBy = "password")
	private Mail mail;

}
