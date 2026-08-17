package com.hibernate.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mall_details")
@Data
public class Mall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mallId;
	private String mallName;

	@Column(name = "floors")
	private int numberOfFloors;
	@Column(name = "shops")
	private int numberOfShops;
	private LocalTime openingTime;
	private LocalTime closingTime;

	private MallStaff mallStaff;

}
