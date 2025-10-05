package com.canoz.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.canoz.entities.Student;
import com.canoz.repository.StudentRepository;
import com.canoz.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent (Student student) {
		return studentRepository.save(student);
		
	}
	@Override 
	public List<Student> getAllStudents () {
	List<Student> studentList=	studentRepository.findAll();
		return studentList;
		
	}
	@Override
	public Student getStudentById(Integer Id) {
		Optional<Student> studentOptional = studentRepository.findById(Id); // dönen değer optional değerdir 
		
		if(studentOptional.isPresent()) {
			return studentOptional.get(); // student döner 
			
			
		}
		return null;
	}

	@Override
	public void deleteStudentById(@PathVariable(name="Id") Integer Id) {
		Student dbStudent=getStudentById(Id);
		if(dbStudent!=null) {
			 
			studentRepository.delete(dbStudent);
			
		}

		
	}
	@Override
	public Student updateStudent(Integer Id, Student updatedStudent) {
		// TODO Auto-generated method stub
		Student dbStudent= getStudentById(Id);
		if(dbStudent!= null) {
			dbStudent.setFirstName(updatedStudent.getFirstName());
			dbStudent.setLastName(updatedStudent.getLastName());
			dbStudent.setBirthOfDate(updatedStudent.getBirthOfDate());
			return studentRepository.save(dbStudent);
			
		}
		return null;
	}

}
