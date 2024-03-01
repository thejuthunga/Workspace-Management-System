package com.ff.workspacemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.HeadOffice;
import com.ff.workspacemanagementsystem.service.HeadOfficeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/")
public class HeadOfficeController {

	@Autowired
	private HeadOfficeService headOfficeService;

	// Save Head Office
	@Operation(description = "Add HeadOffice",summary = "add headoffice")
	@ApiResponse(description = "HeadOffice Created",responseCode = "201")
	@PostMapping("/headOffice")
	public ResponseEntity<ResponseStructure<HeadOffice>> saveHeadOffice(@RequestBody HeadOffice headOffice) {
		return headOfficeService.saveHeadOffice(headOffice);
	}

	// update Head Office
	@Operation(description = "Update HeadOffice",summary = "update headoffice")
	@ApiResponse(description = "OK",responseCode = "200")
	@PutMapping("/headOffice/{headOfficeId}")
	public ResponseEntity<ResponseStructure<HeadOffice>> updateHeadOffice(@PathVariable int headOfficeId,
			@RequestBody HeadOffice headOffice) {
		return headOfficeService.updateHeadOffice(headOfficeId, headOffice);
	}

	// Find  Head Office
	@Operation(description = "Find HeadOffice",summary = "find headoffice")
	@ApiResponse(description = "Found",responseCode = "302")
	@GetMapping("/headOffice/{headOfficeId}")
	public ResponseEntity<ResponseStructure<HeadOffice>> findHeadOfficeById(@PathVariable int headOfficeId) {
		return headOfficeService.findHeadOfficeById(headOfficeId);
	}

	// find all head office
	@Operation(description = "Find All HeadOffice",summary = "find all head office")
	@ApiResponse(description = "Found",responseCode = "302")
	@GetMapping("/headOffice")
	public ResponseEntity<ResponseStructure<List<HeadOffice>>> findAllHeadOffice() {
		return headOfficeService.findAllHeadOffice();
	}
}
