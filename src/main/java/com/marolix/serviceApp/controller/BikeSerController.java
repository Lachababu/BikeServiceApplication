package com.marolix.serviceApp.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.serviceApp.dto.CustomerDto;
import com.marolix.serviceApp.dto.VehicleDto;
import com.marolix.serviceApp.entity.Customers;
import com.marolix.serviceApp.exception.CustomerException;
import com.marolix.serviceApp.service.CustomerSer;

import jakarta.validation.Valid;


@RestController
@Validated
public class BikeSerController {
	@Autowired
	private CustomerSer custSer;
	//private VehicleSer vehSer;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addDetails(@Valid @RequestBody CustomerDto custDto) throws CustomerException {
		custSer.addDetails(custDto);
		return new ResponseEntity<>("Created successfully...", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/Id/{id}")
    public CustomerDto viewDetails(@PathVariable Integer id) throws Exception {
		 CustomerDto c= custSer.viewDetailsById(id);
		return c;
		
	}
	@GetMapping(value="/CustEmail/{email}")
    public CustomerDto viewDetailsByEmail(@PathVariable("email") String email) throws Exception {
		 CustomerDto c= custSer.viewDetailsByEmail(email);
		return c;
		
	}
	
	@DeleteMapping(value="/id/{id}")
	public String deleteById(@PathVariable Integer id) {
		custSer.deleteDetailsById(id);
		return "Deleted";
		
	}
	@PutMapping(value="/id/{id}/name/{owner}")
	public ResponseEntity<CustomerDto> updateName(@PathVariable Integer id,@PathVariable("owner") String name) throws Exception {
	CustomerDto c=	custSer.updateName(id, name);
		return new ResponseEntity<CustomerDto>(c,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getDetails")
	public List<Customers> getDetails() throws CustomerException{
		List<Customers> c1=   custSer .findAllBySorting();
		return c1;
		
	}
	
	@PostMapping("/vehicle/{name}")
	public ResponseEntity<CustomerDto> addVehicleByname(@PathVariable("name") String name,@RequestBody VehicleDto dto)
	{
		CustomerDto  dto2=custSer.addBike(dto, name);
		return new ResponseEntity<CustomerDto>(dto2,HttpStatus.OK);
	}
	

	 

}
