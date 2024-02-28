package com.ff.workspacemanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.HeadOffice;
import com.ff.workspacemanagementsystem.exception.BranchNotFoundException;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.HeadOfficeRepository;

@Repository
public class BranchDao {
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	HeadOffice headOffice;
	@Autowired
	HeadOfficeRepository headOfficeRepository;
	
	public Branch saveBranch(int id,Branch branch) {
		Optional<HeadOffice> optional = headOfficeRepository.findById(id);
		if(optional.isPresent()) {
			List<Branch> branches = optional.get().getBranches();
			branches.add(branch);
		}
		return branchRepository.save(branch);
	}
	
	public Branch updateBranch(int id,Branch branch) {
		Optional<HeadOffice> optional = headOfficeRepository.findById(id);
		if(optional.isPresent()) {
			List<Branch> branches = optional.get().getBranches();
			branches.add(branch);
		}
		return branchRepository.save(branch);
	}
		
	public Branch findBranch(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} 
		throw new BranchNotFoundException();
	}
	public String deleteBranch(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isPresent()) {
			branchRepository.delete(optional.get());
			return "Branch Deleted";
		} 
		throw new BranchNotFoundException();	
	}
	
	public List<Branch> findAllBranch(int hos_id){
		Optional<HeadOffice> optional = headOfficeRepository.findById(hos_id);
		if(optional.isPresent()) {
			return  optional.get().getBranches();
		}
		throw new BranchNotFoundException();
		
	}

}
