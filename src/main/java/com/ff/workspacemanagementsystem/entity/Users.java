package com.ff.workspacemanagementsystem.entity;

import com.ff.workspacemanagementsystem.utility.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen",allocationSize = 10,initialValue = 1,sequenceName = "users_sequence")
	private int userId;
	private String userName;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	private String userEmail;
	private int employeeCount;
	
	
	@OneToOne(mappedBy = "users")
	private Floors floors;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public Floors getFloors() {
		return floors;
	}
	public void setFloors(Floors floors) {
		this.floors = floors;
	}
	
	
}
