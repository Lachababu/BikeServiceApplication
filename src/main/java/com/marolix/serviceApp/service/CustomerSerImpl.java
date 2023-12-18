package com.marolix.serviceApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.marolix.serviceApp.dto.CustomerDto;
import com.marolix.serviceApp.dto.VehicleDto;
import com.marolix.serviceApp.entity.Customers;
import com.marolix.serviceApp.entity.Vehicles;
import com.marolix.serviceApp.exception.CustomerException;
import com.marolix.serviceApp.repository.CustomerRepo;

@Service
public class CustomerSerImpl implements CustomerSer {

	@Autowired
	private CustomerRepo custRepo;
//	private VehicleRepo vehicleRepo;

	@Override
	public CustomerDto addDetails(CustomerDto custDetails) throws CustomerException {
		
		Customers cust=custRepo.findByowner(custDetails.getOwner());
		if(cust!=null) 
			 throw new CustomerException("customer name "+custDetails.getOwner()+" already exists...");
		Customers cc = new Customers();
		cc.setOwner(custDetails.getOwner());
		cc.setCustPhnno(custDetails.getCustPhnno());
		cc.setCustCity(custDetails.getCustCity());
		cc.setCustEmail(custDetails.getCustEmail());
		cc.setVehicles(custDetails.getVehicles());

		cc.setDateOfService(custDetails.getDateOfService());

		custRepo.save(cc);

		return custDetails;
	}

	@Override
	public CustomerDto viewDetailsById(Integer id) throws CustomerException {
		Optional<Customers> opt = custRepo.findById(id);

		Customers c = opt.orElseThrow(() -> new CustomerException(" Details Not found with id "));

		CustomerDto cc = new CustomerDto();
		cc.setCustId(c.getCustId());
		cc.setCustCity(c.getCustCity());
		cc.setCustEmail(c.getCustEmail());
		cc.setCustName(c.getOwner());
		cc.setVehicles(c.getVehicles());
		cc.setCustPhnno(c.getCustPhnno());
		cc.setDateOfService(c.getDateOfService());

		return cc;
	}



	@Override
	public CustomerDto viewDetailsByEmail(String custEmail) throws CustomerException {
		Optional<Customers> opt = custRepo.findByCustEmail(custEmail);

		Customers c = opt.orElseThrow(() -> new CustomerException(" Details Not Found with Given Mail "));

		CustomerDto cc = new CustomerDto();
		cc.setCustId(c.getCustId());
		cc.setCustCity(c.getCustCity());
		cc.setCustEmail(c.getCustEmail());
		cc.setCustName(c.getOwner());
		cc.setVehicles(c.getVehicles());
		cc.setCustPhnno(c.getCustPhnno());
		cc.setDateOfService(c.getDateOfService());

		return cc;
	}

	@Override
	public String deleteDetailsById(Integer id) {
		custRepo.deleteById(id);
		return "deleted sucessfully....";
	}

	@Override
	public CustomerDto updateName(Integer id, String name) throws CustomerException {
        Optional<Customers> opt=   custRepo.findById(id);
        Customers c=opt.orElseThrow(()->new CustomerException("Details not found with given id"));
		 
        c.setOwner(name);
        custRepo.save(c);
        CustomerDto dto=new CustomerDto();
        dto.setCustCity(c.getCustCity());
        dto.setCustEmail(c.getCustEmail());
        dto.setCustName(c.getOwner());
        dto.setCustPhnno(c.getCustPhnno());
        dto.setVehicles(c.getVehicles());
        dto.setDateOfService(c.getDateOfService());
        
        return dto;
	}

	@Override
	public List<Customers> findAllBySorting() throws CustomerException {
		Sort s=Sort.by("custId").descending();
		Iterable<Customers> itr=custRepo.findAll(s);
		Iterator<Customers> itr1=itr.iterator();
		List<Customers> cust=new ArrayList<>();
		while(itr1.hasNext()) {
			cust.add(itr1.next());
		}
		if(cust.isEmpty()) {
			throw new CustomerException("Details not available......");
		}
			
		return cust;
	}

	@Override
	public CustomerDto addBike(VehicleDto dto,String name) {
		Optional<Customers> optional=Optional.ofNullable(custRepo.findByowner(name));
		if(optional .isPresent()) {
			Customers customers=optional.get();
			
			Vehicles vehicles=new Vehicles();
			vehicles.setBikeName(dto.getBikeName());
			vehicles.setBikeNo(dto.getBikeName());
			vehicles.setBikeProblemDescription(dto.getBikeProblemDescription());
			
			customers.getVehicles().add(vehicles);
			custRepo.save(customers);
		
			
			CustomerDto cc = new CustomerDto();
			cc.setCustId(customers.getCustId());
			cc.setCustCity(customers.getCustCity());
			cc.setCustEmail(customers.getCustEmail());
			cc.setCustName(customers.getOwner());
			cc.setVehicles(customers.getVehicles());
			cc.setCustPhnno(customers.getCustPhnno());
			cc.setDateOfService(customers.getDateOfService());
			return cc;
		}
		else {
			return null;
		}
		
	}





}
