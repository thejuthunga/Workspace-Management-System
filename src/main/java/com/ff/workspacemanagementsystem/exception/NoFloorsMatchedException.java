package com.ff.workspacemanagementsystem.exception;

public class NoFloorsMatchedException extends RuntimeException{
	String message;

	public NoFloorsMatchedException(String message) {
		this.message = message;
	}
	
	public NoFloorsMatchedException() {
		
	}
}
