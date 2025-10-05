package com.canoz.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="student")
@Getter
@Setter
@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class Student {
	
	@Id 
	@Column(name="id")                            
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@Column(name="first_name",nullable=false) 
	private String firstName;
	
	@Column(name="last_name",nullable=false) 
	private String lastName;
	
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="birth_of_date",nullable=true)
	
	private Date birthOfDate;
		
}
