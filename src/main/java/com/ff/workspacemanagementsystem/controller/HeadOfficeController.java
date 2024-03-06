package com.ff.workspacemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.HeadOffice;
import com.ff.workspacemanagementsystem.exception.ValidationException;
import com.ff.workspacemanagementsystem.service.HeadOfficeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class HeadOfficeController {

	@Autowired
	private HeadOfficeService headOfficeService;

	// Save Head Office
	@Operation(description = "storing headofice details to the DB", summary = "Adding headoffice info")
	@ApiResponse(description = "HeadOffice Created", responseCode = "201")
	@PostMapping("/headOffice")
	public ResponseEntity<ResponseStructure<HeadOffice>> saveHeadOffice(@Valid @RequestBody HeadOffice headOffice,
			BindingResult result) {
		if (result.hasErrors()) {
			String exception = "";
			for (FieldError error : result.getFieldErrors()) {
				exception += error.getDefaultMessage() + ", ";
			}
			throw new ValidationException(exception);
		}

		return headOfficeService.saveHeadOffice(headOffice);
	}

	// update Head Office
	@Operation(description = "update headoffice data", summary = "Update headoffice info")
	@ApiResponse(description = "OK", responseCode = "200")
	@PutMapping("/headOffice/{headOfficeId}")
	public ResponseEntity<ResponseStructure<HeadOffice>> updateHeadOffice(@PathVariable int headOfficeId,
			@Valid @RequestBody HeadOffice headOffice,BindingResult result) {
		if(result.hasErrors()) {
			String exception=" ";
			for(FieldError error:result.getFieldErrors()) {
				exception += error.getDefaultMessage()+",";
			}
			throw new ValidationException(exception);
		}
		return headOfficeService.updateHeadOffice(headOfficeId, headOffice);
	}

	// Find Head Office
	@Operation(description = "find headoffice info based on headoffice id", summary = "find headoffice")
	@ApiResponse(description = "Found", responseCode = "302")
	@GetMapping("/headOffice/{headOfficeId}")
	public ResponseEntity<ResponseStructure<HeadOffice>> findHeadOfficeById(@PathVariable int headOfficeId) {
		return headOfficeService.findHeadOfficeById(headOfficeId);
	}

	// find all head office
	@Operation(description = "list of head office ", summary = "find all head office")
	@ApiResponse(description = "Found", responseCode = "302")
	@GetMapping("/headOffice")
	public ResponseEntity<ResponseStructure<List<HeadOffice>>> findAllHeadOffice() {
		return headOfficeService.findAllHeadOffice();
	}
}
