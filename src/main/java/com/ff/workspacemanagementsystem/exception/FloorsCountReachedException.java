package com.ff.workspacemanagementsystem.exception;

public class FloorsCountReachedException extends RuntimeException {
	
	private String message;

	public FloorsCountReachedException(String message) {
		super();
		this.message = message;
	}

	public FloorsCountReachedException() {
		super();
	}
	
}
