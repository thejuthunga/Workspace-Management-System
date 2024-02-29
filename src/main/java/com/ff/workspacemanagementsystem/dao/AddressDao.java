package com.ff.workspacemanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Address;
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.exception.BranchNotFoundException;
import com.ff.workspacemanagementsystem.repository.AddressRepository;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private BranchDao branchDao;

	// Save Address
	public Address saveAddress(int branchId, Address address) {
		Branch branch = branchDao.findBranch(branchId);
		if (branch != null) {
			branch.setAddress(address);
			return addressRepository.save(address);
		}
		throw new BranchNotFoundException();
	}

	// update Address
	public Address updateAddress(int branchId, Address address) {
		Branch branch = branchDao.findBranch(branchId);
		if (branch != null) {
			Address address1 = branch.getAddress();
			if (address1.getAddressId() == address.getAddressId()) {
				address1.setAddressId(address.getAddressId());
				address1.setCity(address.getCity());
				address1.setState(address.getState());
				branch.setAddress(address);
				return addressRepository.save(address);
			}
		}
		throw new BranchNotFoundException();

	}

	// delete Address
	public boolean deleteAddress(int branchId) {
		Branch branch = branchDao.findBranch(branchId);
		if (branch != null) {
			addressRepository.delete(branch.getAddress());
			return true;
		}
		throw new BranchNotFoundException();
	}
}
