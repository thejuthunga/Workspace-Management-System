package com.ff.workspacemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ff.workspacemanagementsystem.dao.UsersDao;
import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Users;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private ResponseStructure<Users> responseStructure;

	@Autowired
	private ResponseStructure<List<Users>> responseStructureList;

	public ResponseEntity<ResponseStructure<Users>> save(Users user) {

		usersDao.save(user);

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(HttpStatus.CREATED.getReasonPhrase());
		responseStructure.setData(user);

		return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Users>> findUserById(int id) {

		Users user = usersDao.findUserById(id);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setData(user);

		return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Users>>> findAllAdmins() {

		List<Users> user = usersDao.findAllAdmin();

		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructureList.setData(user);

		return new ResponseEntity<ResponseStructure<List<Users>>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Users>>> findAllClients() {

		List<Users> user = usersDao.findAllClients();

		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructureList.setData(user);

		return new ResponseEntity<ResponseStructure<List<Users>>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Users>> update(int id, Users user) {

		usersDao.update(id, user);

		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setData(user);

		return new ResponseEntity<ResponseStructure<Users>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> delete(int id) {

		usersDao.delete(id);

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setData("User details with id " + id + "is deleted.");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> addFloorToClient(int a_id, int c_id, int f_id) {

		usersDao.addFloorToClient(a_id, c_id, f_id);

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(HttpStatus.CREATED.getReasonPhrase());
		responseStructure.setData("Floor "+f_id+" is rented to the client "+c_id);

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> removeClientFromFloor(int a_id, int f_id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean status = usersDao.removeClientFromFloor(a_id, f_id);
		if (status) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
			responseStructure.setData("Client Removed");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
			responseStructure.setData("Error with request");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		}

	}

}
