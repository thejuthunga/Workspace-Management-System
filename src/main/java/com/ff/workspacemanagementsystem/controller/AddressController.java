package com.ff.workspacemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Address;
import com.ff.workspacemanagementsystem.service.AddressService;

@RestController
@RequestMapping("/")
public class AddressController {

	@Autowired
	private AddressService addressService;

	// Update Address
	@PutMapping("/branch/{branchId}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int branchId,
			@RequestBody Address address) {
		return addressService.updateAddress(branchId, address);
	}

	// delete Address
	@DeleteMapping("/{branchId}")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int branchId) {
		return addressService.deleteOrder(branchId);
	}

}
