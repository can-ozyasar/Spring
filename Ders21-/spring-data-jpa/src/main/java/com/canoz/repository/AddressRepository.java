package com.canoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canoz.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
