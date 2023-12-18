package com.marolix.serviceApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicles {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer bikeId;
   private String bikeName;
   private String bikeNo;
   private String bikeProblemDescription;

   
public Integer getBikeId() {
	return bikeId;
}
public void setBikeId(Integer bikeId) {
	this.bikeId = bikeId;
}
public String getBikeName() {
	return bikeName;
}
public void setBikeName(String bikeName) {
	this.bikeName = bikeName;
}
public String getBikeNo() {
	return bikeNo;
}
public void setBikeNo(String bikeNo) {
	this.bikeNo = bikeNo;
}
public String getBikeProblemDescription() {
	return bikeProblemDescription;
}
public void setBikeProblemDescription(String bikeProblemDescription) {
	this.bikeProblemDescription = bikeProblemDescription;
}
public Vehicles(Integer bikeId, String bikeName, String bikeNo, String bikeProblemDescription) {
	super();
	this.bikeId = bikeId;
	this.bikeName = bikeName;
	this.bikeNo = bikeNo;
	this.bikeProblemDescription = bikeProblemDescription;
}
public Vehicles() {
	super();
	
}
   
   
}
