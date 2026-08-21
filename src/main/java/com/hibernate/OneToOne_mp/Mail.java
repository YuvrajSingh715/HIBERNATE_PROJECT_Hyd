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
@Table(name = "mail")
@Data
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mail_id")
	private int id;
	
	private String mail;
	
	@OneToOne
//	@OneToOne(mappedBy = "mail")
	private Password password;
}
