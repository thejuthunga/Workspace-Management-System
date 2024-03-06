package com.ff.workspacemanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;


	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> user_exception(NullPointerException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(BranchNotFoundException exception) {
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ResponseStructure<String>> fieldValidation(ValidationException exception) {
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	
	//floor exceed
	@ExceptionHandler(FloorsExceededException.class)
	public ResponseEntity<ResponseStructure<String>> catchFloorException(FloorsExceededException exception){
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setStatusCode(HttpStatus.FORBIDDEN.value());
		response.setMessage(HttpStatus.FORBIDDEN.getReasonPhrase());
		response.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotFoundExceptions(IdNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NOT FOUND");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(HeadOfficeNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(
			HeadOfficeNotFoundException exception) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
