package com.ff.workspacemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ff.workspacemanagementsystem.dao.BranchDao;
import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Address;
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.exception.BranchNotFoundException;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructure<String> responseStructure1;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int id, Branch branch) {
		responseStructure.setData(branchDao.saveBranch(id, branch));
		responseStructure.setMessage(HttpStatus.CREATED.getReasonPhrase());
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Branch>> findbranch(int id) {
		responseStructure.setData(branchDao.findBranch(id));
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Branch>> Updatebranch(int h_id,int id,Branch branch){
		responseStructure.setData(branchDao.updateBranch(h_id,id,branch));
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deletebranch(int id) {
		responseStructure1.setData(branchDao.deleteBranch(id));
		responseStructure1.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure1.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure1, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(int id) {
		List<Branch> branchs = branchDao.findAllBranch(id);

		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		structure.setData(branchs);
		structure.setMessage(HttpStatus.OK.getReasonPhrase());
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
	}

	// update Address
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int branchId, Address address) {
		Address receivedAddress = branchDao.updateAddress(branchId, address);
		if (receivedAddress != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(receivedAddress);

			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFoundException();
		}
	}
}
