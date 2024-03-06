package com.ff.workspacemanagementsystem.exception;

public class ValidationException extends RuntimeException {
	String message = "";

	public ValidationException() {

	}

	public ValidationException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
