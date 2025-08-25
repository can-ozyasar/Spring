package com.canoz.services;

import java.util.List;
import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoz.model.Employee;
import com.canoz.repository.EmployeeRepository;

@Service  // servis katmanı olduğunu belirtiyoruz  burda kontrollelr yapılacak 
public class EmployeeService {
	
	
	//// Gelen isteğin KONTOLLERİ BURADA YAPILACAK EĞER BAŞARILI İSE REPOSİTORY YE GÖNDERİLECEK KATMANDIR 
	
	@Autowired // enjekte etmek için kullanırız autowierd i
	private EmployeeRepository employeeRepository;// geçiş sağlayabilmek için  service den repository ye
	
	
	
	
	
	public List<Employee> getAllEmployeeList() {
		//// KONTROLLER....
		
		
		return employeeRepository.getAllEmployeList();   // bir üst katmandan gelen değeri döndür bir alt katman alacak   
	}
	
	
	
	
	public Employee getEmployeeById(String id) { // bir üstten gelen isteği  geri dönür
		
	
		return employeeRepository.getEmployeeById(id);
	}
	
	
	
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		return  employeeRepository.getEmployeeWithParams( firstName,  lastName);
	}

}
