package com.canoz.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.canoz.model.Employee;

@Configuration   /// yapay database miz olacak config sınıfı 
public class Appconfig {
	
	@Bean //// olarak işaretledik ve havuza attık ki tek bir değeri kulanabilelim tüm classlarda 
	public List<Employee> employeeList() {
		
		List<Employee> employeeList= new ArrayList<>();
		employeeList.add(new Employee("1","Can","Ozyasar"));
		employeeList.add(new Employee("2","Ensar","Kurban"));
		employeeList.add(new Employee("3","Kemal","Sansar"));
		employeeList.add(new Employee("4","Bora","AKYAZI"));
		employeeList.add(new Employee("5","BerkTuğ","ÖZASLAN"));
		
		return employeeList;  //// DATABASE DEN DÖNMÜŞ DEĞER GİBİ OLSUN BU 
		
	}

}
