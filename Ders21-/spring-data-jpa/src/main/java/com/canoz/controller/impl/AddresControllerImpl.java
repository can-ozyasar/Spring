package com.canoz.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoz.controller.IAddressContoller;
import com.canoz.dto.DtoAdress;
import com.canoz.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AddresControllerImpl implements IAddressContoller {

	@Autowired
	private IAddressService addressService ; 
	
	
	
	@GetMapping(path = "/list/{id}"  )
	@Override
	public DtoAdress findAddAdressById( @PathVariable(name ="id") Long id) {
		// TODO Auto-generated method stub
		return addressService.finDtoAdressById(id);
	}

	
	
}
