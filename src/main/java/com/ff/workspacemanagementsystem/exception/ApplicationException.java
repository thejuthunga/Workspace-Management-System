package com.ff.workspacemanagementsystem.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {
	// id not found
	@org.springframework.web.bind.annotation.ExceptionHandler(HeadOfficeNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(
			HeadOfficeNotFoundException exception) {
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Not Found");
		response.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
	}
}
