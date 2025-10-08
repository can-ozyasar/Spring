package com.canoz.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.canoz.controller.impl.StudentControllerImpl;
import com.canoz.dto.DtoStudent;
import com.canoz.dto.DtoStudentIU;
import com.canoz.entities.Student;
import com.canoz.repository.StudentRepository;
import com.canoz.services.IStudentService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class StudentServiceImpl implements IStudentService{

	
	@Autowired
	private StudentRepository studentRepository;

    
	
	@Override
	public DtoStudent saveStudent (DtoStudentIU dtoStudentIU) { /// dto ile güncellenmiş hali 
		
		Student student = new Student(); // yeni bir student nesnesi oluşturduk 
		DtoStudent responseDtoStudent = new DtoStudent(); // geri dönmek için bir dtostudent oluşturduk 
		BeanUtils.copyProperties(dtoStudentIU, student); // kopyaladık student nesnesine 
		
		Student dbStudent= studentRepository.save(student); // veri tabanına kaydetti ve bize geri döndü 
		
		 BeanUtils.copyProperties(dbStudent, responseDtoStudent); // geri dönemek için oluşturduğumuz dto student için 
		 // veri tabanına kaydettiğğmiz i response dto ya kopyaladık 
		
		return responseDtoStudent;
		
	}
	@Override 
	public List<DtoStudent> getAllStudents () {
		List<DtoStudent> dtoStudentsLists=new ArrayList<>();
	//List<Student> studentList=	studentRepository.findAll();
	//1	List<Student> studentList=	studentRepository.findAllStudents(); // HQL ile yazdığımız Query  
		List<Student> studentList=	studentRepository.findAllStudentsSQL(); // SQL ile yazdığımız query 

		for (Student student : studentList) { // her değeri dto ya ekledik 
		DtoStudent dtoStudent = new DtoStudent();
		BeanUtils.copyProperties(student, dtoStudent);
		dtoStudentsLists.add(dtoStudent);
	}
		return dtoStudentsLists;
		
	} 
	@Override
	public DtoStudent getStudentById(Integer Id) {
		DtoStudent dtoStudent = new DtoStudent();
		//Optional<Student> studentOptional = studentRepository.findById(Id); // dönen değer optional değerdir 
		Optional<Student> studentOptional = studentRepository.findStudentById(Id); //QUERY ile yazılmış fonksiyon

		if(studentOptional.isPresent()) {
			Student dbStudent=studentOptional.get();
			BeanUtils.copyProperties(dbStudent, dtoStudent);
			

			
			
		}                                   
		return dtoStudent;
	}

	@Override
	public void deleteStudentById(@PathVariable(name="Id") Integer Id) {
		
		// şimdi 
		// veri tabanından o kişi varmı diye sorgulama yapınca gelecek değer dto olur 
		// bunu silmek istediğimizde biz student silmek istiyoruz ama silmek için dto gönderiyoruz bunu bulamaz o yüzden 
		
		// veri tabanından student çektik onu sildik                                                                                                                                                     
		Optional<Student> optional= studentRepository.findById(Id);
		
		if(optional.isPresent()) {
			
			 
			studentRepository.delete(optional.get());
			
		}

		 
	}
	@Override
	public DtoStudent updateStudent(Integer Id, DtoStudentIU dtoStudentIU) {
		// TODO Auto-generated method stub
  Optional<Student> optional = studentRepository.findById(Id);
  DtoStudent dtoStudent = new DtoStudent();
  
if(optional.isPresent()) {
	Student dbStudent = optional.get();
	dbStudent.setFirstName(dtoStudentIU.getFirstName());
	dbStudent.setLastName(dtoStudentIU.getLastName());
	dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
	Student updatedStudent=studentRepository.save(dbStudent); //  değeri kaydettik ama bu student dönüyor bize dto student döndürmemiz lazım 
			BeanUtils.copyProperties(updatedStudent, dtoStudent); // student i dto nesnesine kaydettik 
			return dtoStudent;
			
		}
		return null;
	}

}
