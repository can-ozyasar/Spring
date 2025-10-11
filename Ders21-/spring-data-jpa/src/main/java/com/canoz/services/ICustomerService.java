package com.canoz.services;

import com.canoz.dto.DtoCustomer;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(long Id);

}
