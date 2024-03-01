package com.ff.workspacemanagementsystem.exception;

public class BranchNotFoundException extends RuntimeException {
	
	String message="Branch ID not Found";

	public BranchNotFoundException(String message) {
		this.message = message;
	}

	public BranchNotFoundException() {
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
