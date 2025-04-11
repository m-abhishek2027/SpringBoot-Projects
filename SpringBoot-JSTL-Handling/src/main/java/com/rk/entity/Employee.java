package com.rk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tata_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	@Column(length = 30)
	private String ename;
	@NonNull
	@Column(length = 20)
	private String degn;
	@NonNull
	@Column(length = 30)
	private String addr;
	@NonNull
	private Long phno;
	@NonNull
	private Double salary;
	@NonNull
	@Column(length = 30)
	private String pass;
	
	
	
}
