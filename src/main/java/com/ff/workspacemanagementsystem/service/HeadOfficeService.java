package com.ff.workspacemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ff.workspacemanagementsystem.dao.HeadOfficeDao;
import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.HeadOffice;
import com.ff.workspacemanagementsystem.exception.HeadOfficeNotFoundException;

@Service
public class HeadOfficeService {
	@Autowired
	private HeadOfficeDao headOfficeDao;

	// save Head Office
	public ResponseEntity<ResponseStructure<HeadOffice>> saveHeadOffice(HeadOffice headOffice) {
		HeadOffice receivedHeadOffice = headOfficeDao.saveHeadOffice(headOffice);
		ResponseStructure<HeadOffice> responseStructure = new ResponseStructure<HeadOffice>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedHeadOffice);
		return new ResponseEntity<ResponseStructure<HeadOffice>>(responseStructure, HttpStatus.CREATED);
	}

	// update Head Office
	public ResponseEntity<ResponseStructure<HeadOffice>> updateHeadOffice(int id, HeadOffice headOffice) {
		HeadOffice receivedHeadOffice = headOfficeDao.updateHeadOffice(id, headOffice);
		if (receivedHeadOffice != null) {
			ResponseStructure<HeadOffice> responseStructure = new ResponseStructure<HeadOffice>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(receivedHeadOffice);

			return new ResponseEntity<ResponseStructure<HeadOffice>>(responseStructure, HttpStatus.OK);
		} else {
			throw new HeadOfficeNotFoundException("HeadOffice ID :" + id + ", Not present in DB");
		}
	}

	// Find All Head Office
	public ResponseEntity<ResponseStructure<List<HeadOffice>>> findAllHeadOffice() {
		List<HeadOffice> receivedHeadOffice = headOfficeDao.findAllHeadOffice();
		if (receivedHeadOffice.size() > 0 && receivedHeadOffice != null) {
			ResponseStructure<List<HeadOffice>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(receivedHeadOffice);

			return new ResponseEntity<ResponseStructure<List<HeadOffice>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NullPointerException();
		}
	}

	// find Head office by id
	public ResponseEntity<ResponseStructure<HeadOffice>> findHeadOfficeById(int id) {
		HeadOffice receivedHeadOffice = headOfficeDao.findHeadOfficeById(id);
		if (receivedHeadOffice != null) {
			ResponseStructure<HeadOffice> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(receivedHeadOffice);

			return new ResponseEntity<ResponseStructure<HeadOffice>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new HeadOfficeNotFoundException("HeadOffice ID :" + id + ", Not present in DB");
		}
	}
}
