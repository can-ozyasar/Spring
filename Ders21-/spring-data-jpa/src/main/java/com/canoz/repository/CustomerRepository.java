package com.canoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canoz.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	

}
