package com.marolix.serviceApp.dto;

public class VehicleDto {

	
	private String bikeName;
//	@NotBlank
//	@Pattern(regexp = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{2}[0-9]{4}",message = "Bike Number Not Valid...")
	private String bikeNo;
	private String bikeProblemDescription;

	

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

	public VehicleDto( String bikeName, String bikeNo, String bikeProblemDescription) {
		super();
		
		this.bikeName = bikeName;
		this.bikeNo = bikeNo;
		this.bikeProblemDescription = bikeProblemDescription;
	}

	public VehicleDto() {
		super();

	}
}
