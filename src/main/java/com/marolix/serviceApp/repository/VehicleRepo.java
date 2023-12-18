package com.marolix.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.serviceApp.entity.Vehicles;

public interface VehicleRepo extends JpaRepository<Vehicles, Integer>{
	

}
