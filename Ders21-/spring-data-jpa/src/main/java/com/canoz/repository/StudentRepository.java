package com.canoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canoz.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
// jpaRepository nini aldığı parametreler tablo olan clasımız ve onun id sinin tipi 
	
	
	// BUralara Kendi özel Metodlarımızı Yazacağız.
}
