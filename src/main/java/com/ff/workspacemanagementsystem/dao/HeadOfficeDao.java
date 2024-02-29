package com.ff.workspacemanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.HeadOffice;
import com.ff.workspacemanagementsystem.repository.HeadOfficeRepository;

@Repository
public class HeadOfficeDao {
	@Autowired
	private HeadOfficeRepository headOfficeRepository;

	// save Head office
	public HeadOffice saveHeadOffice(HeadOffice headOffice) {
		return headOfficeRepository.save(headOffice);
	}

	// update Head office
	public HeadOffice updateHeadOffice(int id, HeadOffice headOffice) {
		HeadOffice receivedHeadOffice = findHeadOfficeById(id);
		if (receivedHeadOffice != null) {
			int number=receivedHeadOffice.getOfficeId();
			headOfficeRepository.delete(receivedHeadOffice);
			headOffice.setOfficeId(number);
			return headOfficeRepository.save(headOffice);
		} else {
			return null;
		}
	}

	// find Head office
	public HeadOffice findHeadOfficeById(int id) {
		Optional<HeadOffice> optional = headOfficeRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// find All Head office
	public List<HeadOffice> findAllHeadOffice() {
		return headOfficeRepository.findAll();
	}
}
