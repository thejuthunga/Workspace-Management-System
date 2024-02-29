package com.ff.workspacemanagementsystem.exception;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;


@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler{
	
	@Autowired
	ResponseStructure<String> responseStructure;
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(BranchNotFoundException exception){
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	// id not found
	@ExceptionHandler(HeadOfficeNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(HeadOfficeNotFoundException exception) {
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("Not Found");
		response.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.NOT_FOUND);
	}




}
