package com.canoz.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoz.dto.DtoAdress;
import com.canoz.dto.DtoCustomer;
import com.canoz.entities.Address;
import com.canoz.repository.AddressRepository;
import com.canoz.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository adressRepository;

	@Override
	public DtoAdress finDtoAdressById(Long id) {
		DtoAdress dtoaddress = new DtoAdress();
		Optional<Address> optional = adressRepository.findById(id);

		if (optional.isEmpty()) {
			return null;
		}
		Address address = optional.get();
		BeanUtils.copyProperties(address,dtoaddress );
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		dtoCustomer.setId(address.getCustomer().getId());
dtoCustomer.setName(address.getCustomer().getName());
//dtoCustomer.setAddress(dtoaddress);

		
		
		
		dtoaddress.setCustomer(dtoCustomer);
		

		return dtoaddress;
	}

}
