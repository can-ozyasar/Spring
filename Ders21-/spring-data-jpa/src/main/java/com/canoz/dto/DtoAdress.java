package com.canoz.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAdress {

	

	private long id;
	
	
	private String description;
	private DtoCustomer customer;
	
	
}
