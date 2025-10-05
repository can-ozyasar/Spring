package com.canoz.services;

import java.util.List;

import com.canoz.dto.DtoStudent;
import com.canoz.dto.DtoStudentIU;
import com.canoz.entities.Student;

public interface IStudentService {

	
	/// şimdi DTO YA göre düzenlenmiş halini yazalım .ders28
	
	//public Student saveStudent (Student student); // dto öncesi
	public DtoStudent saveStudent (DtoStudentIU student);  // dto sonrası (insort update olduğu için dtostudentıu  kullandık )
   // geri dönerken de dtoStudent döneriz daha az veriyi gösteren  modelimiz 
	
	public List<DtoStudent>getAllStudents();
	
	public DtoStudent getStudentById(Integer Id);
	public void deleteStudentById(Integer Id);
	
//	public Student updateStudent(Integer Id,Student updatedStudent);// dto öncesi
	public DtoStudent updateStudent(Integer Id,DtoStudentIU dtoStudentIU);// dto sonrası 
}
