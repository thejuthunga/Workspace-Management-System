package com.ff.workspacemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Address;
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.service.BranchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/")
public class BranchController {
	@Autowired
	BranchService service;

	@Operation(description = "Add Branch",summary = "add branch")
	@ApiResponse(description = "Branch Created",responseCode = "201")
	@PostMapping("/headoffice/{headOfficeId}/addbranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@PathVariable int headOfficeId, @RequestBody Branch branch) {
		return service.saveBranch(headOfficeId, branch);
	}

	@Operation(description = "Find Branch",summary = "find branch")
	@ApiResponse(description = "Branch Found",responseCode = "302")
	@GetMapping("/branch/{branchId}")
	public ResponseEntity<ResponseStructure<Branch>> findbranch(@PathVariable int branchId) {
		return service.findbranch(branchId);
	}

	@Operation(description = "Find All Branch",summary = "find all branch")
	@ApiResponse(description = "Branch Found",responseCode = "302")
	@GetMapping("/allbranch/{headOfficeId}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(@PathVariable int headOfficeId) {
		return service.findAllBranch(headOfficeId);
	}

	@Operation(description = "Update Branch",summary = "update branch")
	@ApiResponse(description = "OK",responseCode = "200")
	@PutMapping("/update/{h_id}/branch/{branchId}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int h_id, @PathVariable int branchId,@RequestBody Branch branch){
		return service.Updatebranch(h_id,branchId, branch);
	}

	@Operation(description = "Delete Branch",summary = "delete branch")
	@ApiResponse(description = "OK",responseCode = "200")
	@DeleteMapping("/branch/{branchId}")
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@PathVariable int branchId) {
		return service.deletebranch(branchId);

	}

	@Operation(description = "Update Address",summary = "update address")
	@ApiResponse(description = "OK",responseCode = "200")
	// Update Address
	@PutMapping("/address/{branchId}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int branchId,
			@RequestBody Address address) {
		return service.updateAddress(branchId, address);
	}
}
