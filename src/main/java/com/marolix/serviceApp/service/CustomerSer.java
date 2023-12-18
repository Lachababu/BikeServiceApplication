package com.marolix.serviceApp.service;

import java.util.List;

import com.marolix.serviceApp.dto.CustomerDto;
import com.marolix.serviceApp.dto.VehicleDto;
import com.marolix.serviceApp.entity.Customers;
import com.marolix.serviceApp.exception.CustomerException;

public interface CustomerSer {
	public CustomerDto addDetails(CustomerDto custDetails) throws CustomerException;
	public CustomerDto viewDetailsById(Integer id) throws CustomerException;
	
	public CustomerDto viewDetailsByEmail(String custEmail) throws CustomerException;
	public String deleteDetailsById(Integer id); 
	
	public CustomerDto updateName(Integer id,String name) throws CustomerException;
	public List<Customers> findAllBySorting() throws CustomerException;
	public CustomerDto addBike(VehicleDto dto,String name);

	

}
