package com.ff.workspacemanagementsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.HeadOfficeRepository;

@SpringBootTest(classes = WorkspaceManagementSystemApplication.class)
public class BranchTests {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private HeadOfficeRepository headOfficeRepository;
	
	@Test
	public void saveBranch() {
		Branch branch=new Branch();
		
		branch.setBranchContact(1234);
		branch.setFloorsCount(5);
		branch.setAddress(null);
		branch.setHeadOffice(null);
		branch.setFloors(null);
		
		assertEquals(branch, branchRepository.save(branch));
	}
	
	@Test
	public void findBranch() {
		Optional<Branch> opt=branchRepository.findById(100);
		if(opt.isPresent()) {
			Branch b=opt.get();
			assertEquals(100, b.getBranchId());
		}
	}
	
	@Test
	public void updateBranch() {
		Branch branch=new Branch();
		
		branch.setBranchId(100);
		branch.setBranchContact(9876);
		branch.setFloorsCount(4);
		branch.setAddress(null);
		branch.setFloors(null);
		branch.setHeadOffice(null);
		
		assertEquals(branch.toString(), branchRepository.save(branch).toString());
		
	}
	
}
