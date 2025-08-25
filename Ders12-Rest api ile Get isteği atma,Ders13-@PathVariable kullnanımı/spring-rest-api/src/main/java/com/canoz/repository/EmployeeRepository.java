package com.canoz.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canoz.model.Employee;

@Repository  // repossitory olarak işaretledik 
public class EmployeeRepository {
	
	@Autowired // Yapay veri tabanında  oluşan ve contexte attığımız değeri alıyoruz .
	private List<Employee> employeList;  // giti ve contexte oluşmuş olan employeLİst i aldı datadan gibi 
	
	public List<Employee> getAllEmployeList() {
		//// SERVİCE DEN GELEN LİSTEYİ VERİ TABANINDAN ALMASI GEREK bu adımda
		////// BU DERSTE YAPAY BİR VERİ TABANI İLE DERSİ İLERLETECEĞİZ 
		
		
		return employeList;
		
	}
	
	
	public Employee getEmployeeById(String id){ // dışarıdan gelen id yi bulunca döndürür 
		
		Employee findEmployee =null;
	for (Employee employee :employeList) {
		if(id.equals(employee.getId())) {
			findEmployee=employee;
			break;
			
			
		}
		
	}
	return findEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		
		List<Employee> employeeWithParams=new ArrayList<>();
		
		if(firstName==null&&lastName==null)  // istekte her iki değer yok ise listenin  tamamını dön 
			employeeWithParams= employeList;
		
		
		
		for (Employee employee : employeList) {
			
			if(firstName!=null&& lastName!=null) { // iki değer de dolu ise varsa dön 
				if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
					
					employeeWithParams.add(employee);
				}
			}
			
			if(firstName!=null&& lastName==null) { //firstName var lastName yok ise  >>> değer listede varsa ekle  
				if(employee.getFirstName().equalsIgnoreCase(firstName) ) {
					
					employeeWithParams.add(employee);
				}
			}
			
			if(firstName==null&& lastName!=null) {  //firstName yok lastName var ise  >>> değer listede varsa ekle 
				if( employee.getLastName().equalsIgnoreCase(lastName)) {
					
					employeeWithParams.add(employee);
				}
			}
				
			
		}
		
		
		return employeeWithParams;
	}
	
	
	

}
