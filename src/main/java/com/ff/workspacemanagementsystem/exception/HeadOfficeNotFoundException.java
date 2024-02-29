package com.ff.workspacemanagementsystem.exception;

public class HeadOfficeNotFoundException extends RuntimeException {
	private String message = "Head Office Id is not present";

	// default constructor
	public HeadOfficeNotFoundException() {

	}

	// parameterized constructor
	public HeadOfficeNotFoundException(String message) {
		this.message = message;
	}

	// override getMessage()
	@Override
	public String getMessage() {
		return message;
	}
}
