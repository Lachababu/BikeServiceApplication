package com.marolix.serviceApp.dto;

import java.time.LocalDate;
import java.util.List;
import com.marolix.serviceApp.entity.Vehicles;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerDto {

	private Integer custId;
	@NotBlank(message = "Owner Name should not be null..")
	@Pattern(regexp = "[a-zA-z]+", message = "Please Give a valid Owner Name...")
	private String owner;
	@Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Please Give a Valid Mobile Number")
	private String custPhnno;
	private String custCity;
	@NotBlank(message = "Email Should not be null.. ")
	@Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z]{5}+.[a-zA-Z]{3}", message = "Please Give a Valid Email ID..")
	private String custEmail;

	private LocalDate dateOfService;

	private List<Vehicles> vehicles;

	public CustomerDto(Integer custId, String owner, String custPhnno, String custCity, String custEmail,
			LocalDate dateOfService, List<Vehicles> vehicles) {
		super();
		this.custId = custId;
		this.owner = owner;
		this.custPhnno = custPhnno;
		this.custCity = custCity;
		this.custEmail = custEmail;
		this.dateOfService = dateOfService;
		this.vehicles = vehicles;
	}

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

	public void setCustName(String owner) {
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

	public CustomerDto() {
		super();

	}

}
