package com.ff.workspacemanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ff.workspacemanagementsystem.WorkspaceManagementSystemApplication;
import com.ff.workspacemanagementsystem.entity.HeadOffice;


@SpringBootTest(classes = WorkspaceManagementSystemApplication.class)
class HeadOfficeDaoTest {

	// Test case for HeadOffice
	@Autowired
	HeadOfficeDao headOfficeDao;

	
	@Test
	//save Head Office
	public void testSave() {
		HeadOffice headOffice = new HeadOffice();
		headOffice.setOfficeName("INDIQUBE");
		headOffice.setOfficeEmail("indiqube@mail.com");
		headOffice.setOfficeWebsite("www.indiqube.com");
		headOffice.setBranchHead("Kaviya");

		HeadOffice headOffice1 = headOfficeDao.saveHeadOffice(headOffice);
		assertEquals(headOffice, headOffice1);
	}

	//get all head office
	@Test
	public void testGetAllHeadOffice() {
		List<HeadOffice> headOffice = headOfficeDao.findAllHeadOffice();
		assertNotNull(headOffice.size());
	}

	//get head office by id
	@Test
	public void testFindById() {
		HeadOffice headOffice1 = headOfficeDao.findHeadOfficeById(122);
		assertEquals(122, headOffice1.getOfficeId());
		assertEquals("indiqube@mail.com", headOffice1.getOfficeEmail());
		assertEquals("Indiqube", headOffice1.getOfficeName());
		assertEquals("www.indiqube.com", headOffice1.getOfficeWebsite());
		assertEquals("Anusha", headOffice1.getBranchHead());
	}

	//update head office
	@Test
	public void testUpdate() {
		HeadOffice headOffice = new HeadOffice();
		headOffice.setOfficeId(122);
		headOffice.setOfficeName("Indicube");
		headOffice.setOfficeEmail("indiqube@gmail.com");
		headOffice.setOfficeWebsite("www.indicube.com");
		headOffice.setBranchHead("Madhuri");

		HeadOffice hd = headOfficeDao.updateHeadOffice(122, headOffice);
		assertEquals(hd, headOffice);
	}
}
