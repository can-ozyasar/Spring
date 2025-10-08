package com.canoz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.canoz.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
// jpaRepository nini aldığı parametreler tablo olan clasımız ve onun id sinin tipi 
	
	
	// BUralara Kendi özel Metodlarımızı Yazacağız.
	
	// diyelim ki jpa repostory de sorgu için bir va
	
	
	// QUERY Anatasyonu 
	
	// HQL kullanıyorsak sınıfın ismi ve değişken ismlerini kullanmak gerekir  
	//SQL kullanıyorsak tablo ve tablo içindeki kolon isimleri kullanılır .
	@Query(value = "from Student" ,nativeQuery = false)  // value HQL formatında yazılmalı yani veri tananıdaki tablo ismi ile değil de class ismi ile yazmakgerekiyor .
	List<Student> findAllStudents();
	// native query = true olursa bu sefer de class ve değişken ismi ile değil de direkt veri tabanındaki tablo değişken isimleri ile işlem yaparız .


	
	//SQL HALİ 
	@Query(value = "select * from student.student" ,nativeQuery = true)  // value HQL formatında yazılmalı yani veri tananıdaki tablo ismi ile değil de class ismi ile yazmakgerekiyor .
	List<Student> findAllStudentsSQL();

	// student.student  şu nun için kullandık student şeması içindeki student tablosunda araştır demek


	@Query(value="from Student s Where s.id= :studentId")
	Optional<Student> findStudentById(Integer studentId);















}
