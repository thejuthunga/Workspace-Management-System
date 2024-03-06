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
import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@Operation(description = "storing user details to the DB",summary = "Adding user info")
	@ApiResponse(description = "Created",responseCode = "201")
	@PostMapping
	public ResponseEntity<ResponseStructure<Users>> save( @RequestBody  Users user) {
		return usersService.save(user);
	}
	
	@Operation(description = "will find and return user data",summary = "Finding user data based on ID")
	@ApiResponse(description = "OK",responseCode = "200")
	@GetMapping("/user/{userid}")
	public ResponseEntity<ResponseStructure<Users>> find(@PathVariable int userid) {
		return usersService.findUserById(userid);
	}
	
	@Operation(description = "will find and return the all admins details",summary = "Get All admins data")
	@ApiResponse(description = "OK",responseCode = "200")
	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<Users>>> findAllAdmins() {
		return usersService.findAllAdmins();
	}
	
	
	@Operation(description = "will return all client details",summary = "Get All Client Details")
	@ApiResponse(description = "OK",responseCode = "200")
	@GetMapping("/clients")
	public ResponseEntity<ResponseStructure<List<Users>>> findAllClients() {
		return usersService.findAllClients();
	}
	
	
	@Operation(description = "will update exsiting user and store in DB",summary = "Updating user details based on Id")
	@ApiResponse(description = "Updated",responseCode = "200")
	@PutMapping("/user/{userid}")
	public ResponseEntity<ResponseStructure<Users>> update(@PathVariable int userid, @RequestBody Users user) {
		return usersService.update(userid, user);
	}
	
	@Operation(description = "user will delete from DB",summary = "Deletes the user based on ID")
	@ApiResponse(description = "Deleted",responseCode = "200")
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int userid) {
		return usersService.delete(userid);
	}
	
	
	@Operation(description = "adds floor to client based on client requirement",summary = "Adding Floor to client")
	@ApiResponse(description = "Floor Added to Client",responseCode = "200")
	@PostMapping("/addFloorToClient/{adminId}/{clientId}/{branchId}")
	public ResponseEntity<ResponseStructure<String>> addFloorToClient(@PathVariable int adminId,@PathVariable int clientId, @PathVariable int branchId){
		return usersService.addFloorToClient(adminId, clientId, branchId);
	}
	
	@Operation(description = "removes the floor and client connection",summary = "Removeing the client from floor")
	@ApiResponse(description = "Removed",responseCode = "200")
	@DeleteMapping("/removeClientFromFloor/{adminId}/{floorId}")
	public ResponseEntity<ResponseStructure<String>> removeClientFrom(@PathVariable int adminId,@PathVariable int floorId){
		return usersService.removeClientFromFloor(adminId, floorId);
	}
}
