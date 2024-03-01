package com.ff.workspacemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ff.workspacemanagementsystem.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{


}
