package com.canoz.controller;

import java.nio.Buffer;
import java.util.List;

import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canoz.model.Employee;
import com.canoz.services.EmployeeService;

@RestController  // controller olduğunu belirtmek için "- @restcontroller -"  kullanırız 
@RequestMapping("/rest/api/employee") // sışarıdan bana localhost dan  gelen istekler için bu eklemeyi yapar  /employe-list ---->> rest/api/employee-list gibi olur 
public class RestEmployeeController { // bu isimlendirme formatıdır 

	
	// controller -> service
  // bu işaretleme ile enjekte etmiş oluyoruz bidahaki katman olan service ye 
	@Autowired
	private EmployeeService employeeService;
	
	
	
	/// dışardan gelecek isteğin "post get vs "nin karşılığı olan fonksiyonu belirtmek gerek
	@GetMapping(path = "/list") // örnek get/employee-list dedimi burası gelir 
	public List<Employee> getAllEmployeeList() {
		
		/// sen dışardan istemciden isteği aldın  bu isteği servise yönlendir 
		return 	employeeService.getAllEmployeeList(); //// üsten gelen değeri o da bir alta döndürüyor yani kullanıcıya 

	}  
	
	
	@GetMapping(path ="/list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id" ,required = true) String id) {
		 ////   @ path variable ile  required = true zorunulu olarak id değeri sana gelecek anlamında 
		 /// istekte olan { id} değerini tutmak için kullanırız pathvariable yi , name ye de istekteki ismi veriyoruz  gelen değer aynı isimli olan id ile eşleşir  
		return employeeService.getEmployeeById(id);
		
		
		
	}
	
	
	//!!!! EĞER GETMAPPİN İLE AYNI PATH DEĞERİİ VERİRSEK HATA ALIRIZ PROGRAM HANGİSİNİ ÇALIŞTIRACAĞINI BİLEMEZ 

	
	
	//@GetMapping(path = "employee-list")
	@GetMapping(path="/with-param")
	public List<Employee>getEmployeeWithParams(@RequestParam(name="firstName",required = false) String firstName	,
											   @RequestParam(name="lastName",required = false)String lastName){
	
	// istek şu şekilde:--> http://localhost:8080/rest/api/employee-list?firstName=Can&lastName=Ozyasar
	
	// alınacak değişkenler atılan istekteki ile aynı olmalı  (name="firstName")
	// Tip belirmeden sonraki isim olarak istenen isim verilebilir ama aynı verilmesi daha iyi olur String firstName 
	
		
		// eğer istekte verilen özellikler isteğe bağlı olarak verilemsini istediğimiz varsa  ona ---> required=false   gireriz
		// bu sayede eğer lastname vermeden istek atarsak program hata vermez 
		// http://localhost:8080/rest/api/employee-list?lastName=Ozyasar  çalışır
		// http://localhost:8080/rest/api/employee-list?firstName=Can çalışır 
		
		
		
		System.out.print(firstName+" "+lastName);
		return  employeeService.getEmployeeWithParams( firstName,  lastName);

	}
	
   }
