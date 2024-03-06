package com.ff.workspacemanagementsystem;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ff.workspacemanagementsystem.dao.BranchDao;
import com.ff.workspacemanagementsystem.entity.Address;
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.HeadOffice;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.HeadOfficeRepository;

@SpringBootTest(classes = WorkspaceManagementSystemApplication.class)
public class BranchTests {
	
	@Autowired
	private BranchDao dao;
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	HeadOfficeRepository headOfficeRepository;
	
	@Test
	public void saveBranch() {
		Optional<HeadOffice> optional = headOfficeRepository.findById(2);
		HeadOffice headOffice = optional.get();
		Branch branch=new Branch();
		Address address= new Address();
		address.setCity("Madurai");
		address.setState("TN");
		branch.setBranchContact(123456);
		branch.setFloorsCount(6);
		branch.setAddress(address);
		branch.setHeadOffice(headOffice);
		
		assertEquals(branch, dao.saveBranch(2, branch));
	}
	
	@Test
	public void findBranch() {
		Optional<Branch> optional = branchRepository.findById(111);
		if(optional.isPresent()) {
			Branch branch = optional.get();
			assertEquals(branch, dao.findBranch(111).toString());
		}
		
	}
	
	@Test
	public void updateBranch() {
		Branch branch=new Branch();
		
		branch.setBranchContact(9876);
		branch.setFloorsCount(4);
		
		
		assertEquals(branch.toString(), dao.updateBranch(2, 116, branch));
		
	}
	@Test
	public void deleteBranch() {
			String message="Branch Deleted";
			assertEquals(message, dao.deleteBranch(107));
		
	}
	
	@Test
	public void getAllBranch() {
		List<Branch> list = branchRepository.findAll();
		assertEquals(list, dao.findAllBranch(2));	
	}
	
	@Test
	public void updateAddress(){
		Address address= new Address();
		address.setAddressId(301);
		address.setCity("madurai");
		address.setState("TN");
		assertEquals(address, dao.updateAddress(116, address));;
		
	}
	
	
	
}
