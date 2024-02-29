package com.ff.workspacemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Users>> save(@RequestBody Users user) {
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
	public ResponseEntity<ResponseStructure<Users>> update(@PathVariable int id, @RequestBody Users user) {
		return usersService.update(id, user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int id) {
		return usersService.delete(id);
	}
	
	@PostMapping("/addFloorToClient/{a_id}/{c_id}")
	public ResponseEntity<ResponseStructure<Floors>> addFloorToClient(@PathVariable int a_id,@PathVariable int c_id, @RequestBody Floors floor){
		return usersService.addFloorToClient(a_id, c_id, floor);
	}
}
