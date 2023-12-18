package com.marolix.serviceApp.entity;

import java.time.LocalDate;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Customers {
	   
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer custId;
	  @Column(unique = true)
	 
      private String owner;
      private String custPhnno;
      private String custCity;
      @Column(unique = true)
      private String custEmail;
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      private LocalDate dateOfService;
      
//      private LocalDate dueDate;
      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "CustId",referencedColumnName = "custId")
      private List<Vehicles> vehicles;
	public List<Vehicles> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCustPhnno() {
		return custPhnno;
	}
	public void setCustPhnno(String custPhnno) {
		this.custPhnno = custPhnno;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public LocalDate getDateOfService() {
		return dateOfService;
	}
	public void setDateOfService(LocalDate dateOfService) {
		this.dateOfService = dateOfService;
	}
	public Customers(Integer custId, String owner, String custPhnno, String custCity, String custEmail,
			LocalDate dateOfService) {
		super();
		this.custId = custId;
		this.owner= owner;
		this.custPhnno = custPhnno;
		this.custCity = custCity;
		this.custEmail = custEmail;
		this.dateOfService = dateOfService;
	}
	public Customers() {
		super();
		
	}
	
      
      
      
      
}
