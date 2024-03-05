package com.ff.workspacemanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ff.workspacemanagementsystem.WorkspaceManagementSystemApplication;
import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.repository.FloorsRepository;

@SpringBootTest(classes = WorkspaceManagementSystemApplication.class)
class FloorDaoTest {
	
	@Autowired
	private FloorDao floorDao;
	
	@Autowired
	private FloorsRepository repository;

	@Test
	public void saveFloorTest() {
		Floors floors=new Floors();
		floors.setNoOfCabins(3);
		floors.setNoOfWorkstations(150);
		floors.setIsCafeAvailable(true);
		floors.setIsfloorAvailable(true);
		floors.setBranch(null);
		floors.setUsers(null);
		
		Floors save = repository.save(floors);
		
		assertEquals(floors,save );
	} 

	@Test
	public void getFloorByIdTest() {
		
		Floors floorById = floorDao.getFloorById(440);
		
		
		assertTrue(floorById.getIsCafeAvailable());
		assertEquals(4, floorById.getNoOfCabins());
		assertEquals(2, floorById.getNoOfWorkstations());
		assertTrue(floorById.isIsfloorAvailable());
		assertEquals(100, floorById.getBranch().getBranchId());
	}
	
	@Test
	public void updateFloorTest() {
		Floors floors=new Floors();
		floors.setFloorid(440);
		floors.setNoOfCabins(3);
		floors.setNoOfWorkstations(60);
		floors.setIsCafeAvailable(true);
		floors.setIsfloorAvailable(true);
		
		Floors updateFloor = repository.save( floors);
		
		assertEquals(floors, updateFloor);
	}
	
	
}
