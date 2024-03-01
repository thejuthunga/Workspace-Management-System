package com.ff.workspacemanagementsystem.exception;

public class IdNotFoundException extends RuntimeException{

	private String message="Id is not found";
	
	public IdNotFoundException() {
		
	}
	public IdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
