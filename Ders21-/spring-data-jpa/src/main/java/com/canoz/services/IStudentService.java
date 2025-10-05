package com.canoz.services;

import java.util.List;

import com.canoz.entities.Student;

public interface IStudentService {

	
	public Student saveStudent (Student student);
	
	
	public List<Student>getAllStudents();
	
	public Student getStudentById(Integer Id);
	public void deleteStudentById(Integer Id);
	
	public Student updateStudent(Integer Id,Student updatedStudent);
}
