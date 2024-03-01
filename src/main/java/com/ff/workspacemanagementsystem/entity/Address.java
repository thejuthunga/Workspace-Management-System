package com.ff.workspacemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "address_seq_gen")
	@SequenceGenerator(name = "address_seq_gen", allocationSize = 5, initialValue = 300, sequenceName = "address_sequence")
	private int addressId;
	private String city;
	private String state;

	@OneToOne(mappedBy = "address")
	private Branch branch;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
