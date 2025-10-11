package com.canoz.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoz.dto.DtoAdress;
import com.canoz.dto.DtoCustomer;
import com.canoz.entities.Address;
import com.canoz.entities.Customer;
import com.canoz.repository.CustomerRepository;
import com.canoz.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(long Id) {

		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAdress dtoaddress = new DtoAdress();
		Optional<Customer> optional = customerRepository.findById(Id);
		if (optional.isEmpty()) {

			return null;

		}

		Customer customer = optional.get();
		Address address = optional.get().getAddress();
		
		
		BeanUtils.copyProperties(customer,dtoCustomer);
		BeanUtils.copyProperties(address, dtoaddress);
		dtoCustomer.setAddress(dtoaddress);
		return dtoCustomer;
	}

}
