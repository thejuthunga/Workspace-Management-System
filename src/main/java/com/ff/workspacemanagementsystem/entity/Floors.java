package com.ff.workspacemanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Floors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "floor_seq_gen")
	@SequenceGenerator(name = "floor_seq_gen", allocationSize = 3, initialValue = 400, sequenceName = "floor_sequence")
	private int floorid;
	private int noOfCabins;
	private int noOfWorkstations;

	private Boolean isCafeAvailable;

	private boolean isfloorAvailable;
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Users users;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Branch branch;

	public int getFloorid() {
		return floorid;
	}

	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}

	public int getNoOfCabins() {
		return noOfCabins;
	}

	public void setNoOfCabins(int noOfCabins) {
		this.noOfCabins = noOfCabins;
	}

	public int getNoOfWorkstations() {
		return noOfWorkstations;
	}

	public void setNoOfWorkstations(int noOfWorkstations) {
		this.noOfWorkstations = noOfWorkstations;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
