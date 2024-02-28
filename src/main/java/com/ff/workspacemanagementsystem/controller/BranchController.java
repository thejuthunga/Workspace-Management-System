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
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.service.BranchService;

@RestController
@RequestMapping("/")
public class BranchController {
	@Autowired
	BranchService service;
	@PostMapping("/headoffice/{id}/addbranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@PathVariable int id,@RequestBody Branch branch){
		return service.saveBranch(id, branch);
	}
	
	@GetMapping("branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> findbranch(@PathVariable int id){
		return service.findbranch(id);
	}
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(@PathVariable int id){
		return service.findAllBranch(id);
	}
	@PutMapping("")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int id,@RequestBody Branch branch){
		return service.Updatebranch(id, branch);
	}
	@DeleteMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@PathVariable int id){
		return service.deletebranch(id);
		
	}
	
	
	
	

}
