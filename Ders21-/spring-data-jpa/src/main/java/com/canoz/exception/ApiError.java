package com.canoz.exception;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

	// dönecek hatalar hep bu formatta gelsindiye değşkenler oluşturduk.
	
	
	private String id;
	
	
	private Date errorTime;
	
	private T errors;
}
