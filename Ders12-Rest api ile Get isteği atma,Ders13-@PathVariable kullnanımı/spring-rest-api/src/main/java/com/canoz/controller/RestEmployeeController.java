package com.canoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoz.model.Employee;
import com.canoz.services.EmployeeService;

@RestController  // controller olduğunu belirtmek için "- @restcontroller -"  kullanırız 
@RequestMapping("/rest/api") // sışarıdan bana localhost dan  gelen istekler için bu eklemeyi yapar  /employe-list ---->> rest/api/employee-list gibi olur 
public class RestEmployeeController { // bu isimlendirme formatıdır 

	
	// controller -> service
  // bu işaretleme ile enjekte etmiş oluyoruz bidahaki katman olan service ye 
	@Autowired
	private EmployeeService employeeService;
	
	
	
	// dışardan gelecek isteğin "post get vs "nin karşılığı olan fonksiyonu belirtmek gerek
	@GetMapping(path = "/employee-list") // örnek get/employee-list dedimi burası gelir 
	public List<Employee> getAllEmployeeList() {
		
		// sen dışardan istemciden isteği aldın  bu isteği servise yönlendir 
		return 	employeeService.getAllEmployeeList(); //// üsten gelen değeri o da bir alta döndürüyor yani kullanıcıya 

	}  
	
	
	@GetMapping(path ="/employee-list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id" ,required = true) String id) {
		 ////   @ path variable ile  required = true zorunulu olarak id değeri sana gelecek anlamında 
		 /// istekte olan { id} değerini tutmak için kullanırız pathvariable yi , name ye de istekteki ismi veriyoruz  gelen değer aynı isimli olan id ile eşleşir  
		return employeeService.getEmployeeById(id);
		
		
		
	}
	
	
	
	
}
