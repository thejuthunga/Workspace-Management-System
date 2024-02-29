package com.ff.workspacemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ff.workspacemanagementsystem.dao.AddressDao;
import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Address;
import com.ff.workspacemanagementsystem.exception.BranchNotFoundException;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;

	// update Address
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int branchId, Address address) {
		Address receivedAddress = addressDao.updateAddress(branchId, address);
		if (receivedAddress != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(receivedAddress);

			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException("Branch Id " + branchId + "is Not presend in DB");
		}
	}

	// delete Address
	public ResponseEntity<ResponseStructure<String>> deleteOrder(int branchId) {
		boolean bool = addressDao.deleteAddress(branchId);
		if (bool == true) {
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Address Deleted..!");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException("Branch ID :" + branchId + ", Not present in DB");
		}
	}
}
