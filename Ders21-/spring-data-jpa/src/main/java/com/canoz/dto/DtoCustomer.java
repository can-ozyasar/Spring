package com.canoz.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL) // bu class içinde eğer null değer dönerse onu döndürme 

public class DtoCustomer {

	
	
	private long id;
	
	
	private String name;
	
	private DtoAdress address;
}
