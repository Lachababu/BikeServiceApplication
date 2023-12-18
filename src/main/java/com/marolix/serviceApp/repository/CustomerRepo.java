package com.marolix.serviceApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.serviceApp.entity.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Integer> {

	Customers findBycustId(Integer id);
	Optional<Customers> findByCustEmail(String Email);
	Customers findByowner(String name);

}
