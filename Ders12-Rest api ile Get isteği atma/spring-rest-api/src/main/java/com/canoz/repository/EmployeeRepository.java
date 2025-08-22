package com.canoz.repository;

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

}
