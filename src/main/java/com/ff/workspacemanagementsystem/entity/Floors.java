package com.ff.workspacemanagementsystem.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Floors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "floor_seq_gen")
	@SequenceGenerator(name = "floor_seq_gen", allocationSize = 3, initialValue = 400, sequenceName = "floor_sequence")
	private int floorid;
	
	@Min(value = 3)
	private int noOfCabins;
	@Min(value = 50)
	@Max(value = 200)
	private int noOfWorkstations;
	
	@NotNull(message = "isCafeAvailable must not be null")
	@Column(nullable = false)
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Floors other = (Floors) obj;
		return floorid == other.floorid && Objects.equals(isCafeAvailable, other.isCafeAvailable)
				&& isfloorAvailable == other.isfloorAvailable && noOfCabins == other.noOfCabins
				&& noOfWorkstations == other.noOfWorkstations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(floorid, isCafeAvailable, isfloorAvailable, noOfCabins, noOfWorkstations);
	}

}
