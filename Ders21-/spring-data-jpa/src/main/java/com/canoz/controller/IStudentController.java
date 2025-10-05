package com.canoz.controller;

import java.util.List;

import com.canoz.dto.DtoStudent;
import com.canoz.dto.DtoStudentIU;
import com.canoz.entities.Student;

public interface IStudentController {

	
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent>getAllStudents();
	public DtoStudent getStudentById(Integer Id);
	
	public void deleteStudentById(Integer Id);
	public DtoStudent updateStudent(Integer Id ,DtoStudentIU updateStudentIU);
}
