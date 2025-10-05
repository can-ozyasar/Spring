package com.canoz.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { // bu class ı şu yüzden açtık 
	// şimdi dtostudent get işlemlerinde iyi ama save işlemleri için eksik veriler içeriyor 
	// örnek olarak student eklemek için isim soyisiism birthdate lazım ama biz dto da birthofdate yi kullanmadık bilerek
	// bu yüzden de yeni eleman ekleme gibi bazı işlemelrde dto student yetersiz kalıyor 
	
	// bizde dtostudent ıu  isminde (insort update)  isimli bir class daha oluşturduk güncelleme ekleme işlemeleinde bunu kullanacağız .
	// get işlemelerinde ise dto yu kullanacağız 
	
	
	

	
	
private String firstName;
private String lastName;
private  Date birthOfDate;
}
