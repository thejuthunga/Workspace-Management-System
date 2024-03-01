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

@RestController
@RequestMapping("/system")
public class FloorController {

	@Autowired
	private FloorsService floorsService;

	@PostMapping("/branch/{branchid}/floors")
	public ResponseEntity<ResponseStructure<String>> createFloors(@PathVariable int branchid,
			@RequestBody Floors floors) {
		return floorsService.saveFloor(branchid, floors);
	}

	@GetMapping("/branch/{branchid}/floors/{floorid}")
	public ResponseEntity<ResponseStructure<Floors>> getFloorsByID(@PathVariable int branchid,
			@PathVariable int floorid) {
		return floorsService.getFloorDetails(floorid, branchid);
	}

	@GetMapping("/branch/{branchid}/floors")
	public ResponseEntity<ResponseStructure<List<Floors>>> getAllFloors(@PathVariable int branchid) {
		return floorsService.getAllFloors(branchid);
	}

	@PutMapping("/branch/{branchid}/floors/{floorid}")
	public ResponseEntity<ResponseStructure<Floors>> updateFloors(@PathVariable int branchid, @PathVariable int floorid,
			@RequestBody Floors floors) {
		return floorsService.updateFloor(branchid, floorid, floors);
	}
}
