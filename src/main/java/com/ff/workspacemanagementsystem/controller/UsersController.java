package com.ff.workspacemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Users>> save(@RequestBody @Valid Users user) {
		return usersService.save(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<Users>> find(@PathVariable int id) {
		return usersService.findUserById(id);
	}

	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<Users>>> findAllAdmins() {
		return usersService.findAllAdmins();
	}

	@GetMapping("/clients")
	public ResponseEntity<ResponseStructure<List<Users>>> findAllClients() {
		return usersService.findAllClients();
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<Users>> update(@PathVariable int id, @RequestBody @Valid Users user) {
		return usersService.update(id, user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int id) {
		return usersService.delete(id);
	}
	
	@PostMapping("/addFloorToClient/{a_id}/{c_id}/{b_id}")
	public ResponseEntity<ResponseStructure<String>> addFloorToClient(@PathVariable int a_id,@PathVariable int c_id, @PathVariable int b_id){
		return usersService.addFloorToClient(a_id, c_id, b_id);
	}
	
	@DeleteMapping("/removeClientFromFloor/{a_id}/{f_id}")
	public ResponseEntity<ResponseStructure<String>> removeClientFrom(@PathVariable int a_id,@PathVariable int f_id){
		return usersService.removeClientFromFloor(a_id, f_id);
	}
}
