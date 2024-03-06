package com.ff.workspacemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "headOffice")
@Data
public class HeadOffice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "office_seq_gen")
	@SequenceGenerator(name = "office_seq_gen", allocationSize = 10, initialValue = 1, sequenceName = "office_sequence")
	private int officeId;
	@Size(min = 4  ,message = "Name should contain at least 4 character")
	private String officeName;
	
	@Email(message = "Please enter proper email")
	@Column(unique = true)
	private String officeEmail;
	@Pattern(regexp = "(www.)+[a-zA-Z0-9]+(.com)",message = "Invalid website URL")
	private String officeWebsite;
	
	@NotNull(message = "Branch Head Should Not be Null")
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeadOffice other = (HeadOffice) obj;
		return Objects.equals(branchHead, other.branchHead) && Objects.equals(officeEmail, other.officeEmail)
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName)
				&& Objects.equals(officeWebsite, other.officeWebsite);
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchHead, officeEmail, officeId, officeName, officeWebsite);
	}	
}
