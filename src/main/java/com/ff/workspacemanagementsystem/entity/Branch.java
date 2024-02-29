package com.ff.workspacemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "branch_seq_gen")
	@SequenceGenerator(name = "branch_seq_gen",allocationSize = 5,initialValue = 100,sequenceName = "branch_sequence")
	private int branchId;
	private long branchContact;
	private int floorsCount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Address address;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "branch")
	private List<Floors> floors= new ArrayList<Floors>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "branch")
	private List<Review> reviews =new ArrayList<Review>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private HeadOffice headOffice;
	
	public int getFloorsCount() {
		return floorsCount;
	}
	public void setFloorsCount(int floorsCount) {
		this.floorsCount = floorsCount;
	}
	
	public HeadOffice getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(HeadOffice headOffice) {
		this.headOffice = headOffice;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public long getBranchContact() {
		return branchContact;
	}

	public void setBranchContact(long branchContact) {
		this.branchContact = branchContact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Floors> getFloors() {
		return floors;
	}

	public void setFloors(List<Floors> floors) {
		this.floors = floors;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}
