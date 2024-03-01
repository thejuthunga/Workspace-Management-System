package com.ff.workspacemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "headOffice")
public class HeadOffice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "office_seq_gen")
	@SequenceGenerator(name = "office_seq_gen", allocationSize = 10, initialValue = 1, sequenceName = "office_sequence")
	private int officeId;
	private String officeName;
	@Column(unique = true)
	private String officeEmail;
	private String officeWebsite;
	@Column(nullable = false)
	private String branchHead;
	
	@JsonIgnore
	@OneToMany(mappedBy = "headOffice")
	private List<Branch> branches=new ArrayList<Branch>();


	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeEmail() {
		return officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public String getOfficeWebsite() {
		return officeWebsite;
	}

	public void setOfficeWebsite(String officeWebsite) {
		this.officeWebsite = officeWebsite;
	}

	public String getBranchHead() {
		return branchHead;
	}

	public void setBranchHead(String branchHead) {
		this.branchHead = branchHead;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

}
