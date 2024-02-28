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

@RestController
@RequestMapping("/wms")
public class HeadOfficeController {

	@Autowired
	private HeadOfficeService headOfficeService;

	// Save Head Office
	@PostMapping("/headOffice")
	public ResponseEntity<ResponseStructure<HeadOffice>> saveHeadOffice(@RequestBody HeadOffice headOffice) {
		return headOfficeService.saveHeadOffice(headOffice);
	}

	// update Head Office
	@PutMapping("/headOffice/{headOfficeId}")
	public ResponseEntity<ResponseStructure<HeadOffice>> updateHeadOffice(@PathVariable int headOfficeId,
			@RequestBody HeadOffice headOffice) {
		return headOfficeService.updateHeadOffice(headOfficeId, headOffice);
	}

	// Find all Head Office
	@GetMapping("/headOffice/{headOfficeId}")
	public ResponseEntity<ResponseStructure<HeadOffice>> findHeadOfficeById(@PathVariable int headOfficeId) {
		return headOfficeService.findHeadOfficeById(headOfficeId);
	}

	// find all head office
	@GetMapping("/headOffice")
	public ResponseEntity<ResponseStructure<List<HeadOffice>>> findAllHeadOffice() {
		return headOfficeService.findAllHeadOffice();
	}
}
