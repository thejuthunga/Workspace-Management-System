package com.ff.workspacemanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.repository.FloorRepository;

@Repository
public class FloorDao {
	@Autowired
	private FloorRepository floorRepository;
	
	
	
	public Floors saveFloor(Floors floors) {
		return floorRepository.save(floors);
	}
	
	public Floors getFloorById(int floorid) {
		Optional<Floors> optional = floorRepository.findById(floorid);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Floors updateFloor(int floorid,Floors floors) {
		Floors getFloor = getFloorById(floorid);
		
		if(getFloor != null) {
			floors.setFloorid(getFloor.getFloorid());
			
			return floorRepository.save(floors);
		}
		
		return null;
	}
	
	public String deleteFloor(int floorid) {
		
		Floors floors = getFloorById(floorid);
		if(floors != null) {
		floorRepository.delete(floors);
		return "Floor is Deleted";
		}
		
		return "Failed to delete";
	}
}
