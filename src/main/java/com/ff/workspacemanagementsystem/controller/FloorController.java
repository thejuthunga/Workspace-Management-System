package com.ff.workspacemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.service.FloorsService;

@RestController
@RequestMapping("/system")
public class FloorController {
	
	@Autowired
	private FloorsService floorsService;
	
	@PostMapping("/branch/{branchid}")
	public ResponseEntity<ResponseStructure<String>> createFloors(@PathVariable int branchid,@RequestBody Floors floors){
		return floorsService.saveFloor(branchid,floors);
	}
	
//	public ResponseEntity<ResponseStructure<String>> getFloors(@)
}
