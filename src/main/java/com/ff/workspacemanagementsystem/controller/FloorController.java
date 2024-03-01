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
import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.service.FloorsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/system")
public class FloorController {

	@Autowired
	private FloorsService floorsService;
	
	@Operation(description = "floor data is stored with corresponding branchid",summary = "Floor is created for specified branchid")
	@ApiResponse(description = "Floor Created",responseCode = "201")
	@PostMapping("/branch/{branchid}/floors")
	public ResponseEntity<ResponseStructure<String>> createFloors(@PathVariable int branchid,
			@RequestBody Floors floors) {
		return floorsService.saveFloor(branchid, floors);
	}
	
	@Operation(description = "will find and return the floor data of specified ID",summary = "Get Floor data based on ID")
	@ApiResponse(description = "Found",responseCode = "302")
	@GetMapping("/branch/{branchid}/floors/{floorid}")
	public ResponseEntity<ResponseStructure<Floors>> getFloorsByID(@PathVariable int branchid,
			@PathVariable int floorid) {
		return floorsService.getFloorDetails(floorid, branchid);
	}
	
	@Operation(description = "will find and return all floor details of corresponding branch id",summary = "Get All Floors based on Branch Id")
	@ApiResponse(description = "Found",responseCode = "302")
	@GetMapping("/branch/{branchid}/floors")
	public ResponseEntity<ResponseStructure<List<Floors>>> getAllFloors(@PathVariable int branchid) {
		return floorsService.getAllFloors(branchid);
	}
	
	@Operation(description = "will update and store the floor data to DB based branch Id and floor Id",summary = "Updating exsiting floor details based")
	@ApiResponse(description = "Updated",responseCode = "200")
	@PutMapping("/branch/{branchid}/floors/{floorid}")
	public ResponseEntity<ResponseStructure<Floors>> updateFloors(@PathVariable int branchid, @PathVariable int floorid,
			@RequestBody Floors floors) {
		return floorsService.updateFloor(branchid, floorid, floors);
	}
}
