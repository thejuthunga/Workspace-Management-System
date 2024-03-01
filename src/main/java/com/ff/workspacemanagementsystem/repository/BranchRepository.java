package com.ff.workspacemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ff.workspacemanagementsystem.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

	@Query("select b.floors_count from branch b where b.branch_id = ?1")
	public int getFloorCount(int b_id);


}
