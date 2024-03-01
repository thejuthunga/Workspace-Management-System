package com.ff.workspacemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ff.workspacemanagementsystem.dao.BranchDao;
import com.ff.workspacemanagementsystem.dao.FloorDao;
import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.exception.BranchNotFoundException;
import com.ff.workspacemanagementsystem.exception.FloorsExceededException;

@Service
public class FloorsService {

	@Autowired
	private FloorDao floorDao;

	@Autowired
	private BranchDao branchDao;
	

	public ResponseEntity<ResponseStructure<String>> saveFloor(int branchid, Floors floors) {

		Branch branch = branchDao.findBranch(branchid);
		if (branch.getFloors().size() < branch.getfloorsCount()) {
			if (branch != null) {
				floors.setBranch(branch);
				branch.getFloors().add(floors);
				floorDao.saveFloor(floors);
				
				ResponseStructure<String> structure = new ResponseStructure<String>();
				structure.setMessage("Floor Data inserted");
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setData("Floor Data Stroed in the DB");

				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.CREATED);
			}

		}
		throw new FloorsExceededException();
	}

	public ResponseEntity<ResponseStructure<Floors>> getFloorDetails(int floorid, int branchid) {

		Branch branch = branchDao.findBranch(branchid);

		Floors floors = floorDao.getFloorById(floorid);

		if (floors.getBranch().getBranchId() == branch.getBranchId()) {
			ResponseStructure<Floors> structure = new ResponseStructure<Floors>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Floor Details Found");
			structure.setData(floors);

			return new ResponseEntity<ResponseStructure<Floors>>(structure, HttpStatus.FOUND);

		}
		throw new BranchNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteFloor(int userid, int branchid, int floorid) {
		// need to find user based on id and if user object has perticular branchid then
		// find floorid and delete
		
		
		
		String deleteFloorMessage = floorDao.deleteFloor(floorid);

		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(deleteFloorMessage);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData("Floor deleted from DB");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	
	 public ResponseEntity<ResponseStructure<List<Floors>>> getAllFloors(int branchid){ 
		  
		  Branch branch = branchDao.findBranch(branchid);
		  if(branch != null) {
		  List<Floors> floorslist = branch.getFloors();
		  
		  ResponseStructure<List<Floors>> structure=new ResponseStructure<List<Floors>>();
		  structure.setStatusCode(HttpStatus.FOUND.value());
		  structure.setMessage(HttpStatus.FOUND.getReasonPhrase());
		  structure.setData(floorslist);
		  
		  return new ResponseEntity<ResponseStructure<List<Floors>>>(structure,HttpStatus.FOUND);
		  }
		  throw new BranchNotFoundException();
	  }
	 

	public ResponseEntity<ResponseStructure<Floors>> updateFloor(int branchid, int floorid, Floors floors) {
		Branch branch = branchDao.findBranch(branchid);
		Floors floors2=floorDao.getFloorById(floorid);
//		List<Floors> floorsList = branch.getFloors();
//		for(Floors floor:floorsList) {
//			if(floor.getFloorid()== floorid) {
//				floors.setFloorid(floorid);
//			}
//		}
		
		
		if(floors2!=null &&floors!=null) {
			if(floors.getNoOfWorkstations()!=0) {
				floors2.setNoOfWorkstations(floors.getNoOfWorkstations());
			}
			if(floors.getNoOfCabins()!=0) {
				floors2.setNoOfCabins(floors.getNoOfCabins());
			}
			if(floors.getIsCafeAvailable()!= null) {
				floors2.setIsCafeAvailable(floors.getIsCafeAvailable());
			}
			
		}
		
		Floors updateFloor = floorDao.updateFloor(floors2);
		ResponseStructure<Floors> structure = new ResponseStructure<Floors>();
		structure.setData(updateFloor);
		structure.setMessage("Floor Updated");
		structure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<Floors>>(structure, HttpStatus.OK);
	}
}
