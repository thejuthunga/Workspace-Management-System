package com.ff.workspacemanagementsystem.exception;

public class FloorsExceededException extends RuntimeException{
	String message="Floor count exceeded";

	public FloorsExceededException() {
	
	}

	public FloorsExceededException(String message) {
		
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
