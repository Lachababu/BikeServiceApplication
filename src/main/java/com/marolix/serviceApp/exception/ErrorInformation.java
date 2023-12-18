package com.marolix.serviceApp.exception;

import java.time.LocalDateTime;

public class ErrorInformation {
	private String errorMessage;
	private Integer statusCode;
	private LocalDateTime occuredAt;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getOccuredAt() {
		return occuredAt;
	}

	public void setOccuredAt(LocalDateTime occuredAt) {
		this.occuredAt = occuredAt;
	}

}
