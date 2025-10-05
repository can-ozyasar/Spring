package com.canoz.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoz.controller.IStudentController;
import com.canoz.entities.Student;
import com.canoz.repository.StudentRepository;
import com.canoz.services.IStudentService;


@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{

	@Autowired
	private IStudentService studentService;

@PostMapping(path="/save")
@Override
public Student saveStudent(@RequestBody  Student student) {
	
	
	return studentService.saveStudent(student);
}


@GetMapping(path="/list")
@Override
public List<Student> getAllStudents() {
	
	
	return studentService.getAllStudents();
}

@GetMapping(path="/list/{Id}")
@Override
public Student getStudentById(@PathVariable(name="Id") Integer Id) {
	return studentService.getStudentById(Id);
	
}

@DeleteMapping(path="/delete/{Id}")
@Override
public void deleteStudentById(@PathVariable(name="Id") Integer Id) {
	studentService.deleteStudentById(Id);
	
}

@PutMapping(path="/update/{Id}")
@Override
public Student updateStudent(@PathVariable(name="Id") Integer Id, @RequestBody Student updateStudent) {
	
	return studentService.updateStudent(Id, updateStudent);
}

}
