package com.marolix.serviceApp.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerException.class)
	private ResponseEntity<ErrorInformation> handlerForUserException(CustomerException c){
		ErrorInformation e=new ErrorInformation();
		e.setErrorMessage(c.getMessage());
		e.setOccuredAt(LocalDateTime.now());
		e.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorInformation>(e,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorInformation> exception(Exception e){
		ErrorInformation e1=new ErrorInformation();
		e1.setErrorMessage("Internal Server Error"+e.toString());
		e1.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		e1.setOccuredAt(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInformation>(e1,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ErrorInformation> methodArgNotValidException(MethodArgumentNotValidException m){
		ErrorInformation er=new ErrorInformation();
		er.setOccuredAt(LocalDateTime.now());
		er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		er.setErrorMessage(m.getBindingResult().getAllErrors().stream().map(e1->e1.getDefaultMessage()).collect(Collectors.joining(",")));
		return new ResponseEntity<ErrorInformation>(er,HttpStatus.CREATED);
		
	}
	
	

}
