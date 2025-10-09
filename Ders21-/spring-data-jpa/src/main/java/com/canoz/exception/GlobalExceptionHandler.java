package com.canoz.exception;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@ControllerAdvice   // bu sayede bu sınıfın hata yakalayacak sınıf olsuğunu belirtmiş oluyoruz.
public class GlobalExceptionHandler {
	
	
	private List<String> addMapValue(List<String>list ,String newValue){
		list.add(newValue);
		return list;
	}
	
	// Spring validation dan fırlatılan hatalları alıp yönetmek ve response dönmek 
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)  // yakalamak istediğimiz hatanın gerçek ismini yazıyoruz . // exception yakalayısıcı 
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) { /// yakalanan hata parametre olarak verdik 
		
		Map<String,List<String>> errorsMap= new HashMap<>(); // erorları tutacak error listemiz 
		for ( ObjectError  objError : ex.getBindingResult().getAllErrors()) {
			String fieldName= ((FieldError)objError).getField(); // hangi alanda hata varsa firstName lastName vb.. onu almamızı sağlar 
			if(errorsMap.containsKey(fieldName)) { // ilk hata yada ilkden snraki hata olmasına göre değişecek şekilde ekleme yapacağız 
				// ilk hatada yeni nesne oluşturarak sonrakilede ise eski listeye ekleyerek yazılacak .
				errorsMap.put(fieldName,addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()) );
				
			} 
			else {
				errorsMap.put(fieldName,addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
				
			}
			
			
		}
		return ResponseEntity.badRequest().body(createApiError(errorsMap));
	}
	
	
	
	private <T> ApiError<T> createApiError(T errors) { // T Tipinde 
		
		
		ApiError<T> apiError =new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date(0));
		
		
		apiError.setErrors(errors);
		return apiError;
	}

}
