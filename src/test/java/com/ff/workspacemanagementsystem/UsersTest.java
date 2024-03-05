package com.ff.workspacemanagementsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.repository.UsersRepository;
import com.ff.workspacemanagementsystem.utility.UsersRole;

@SpringBootTest(classes = WorkspaceManagementSystemApplication.class)
public class UsersTest {

	@Autowired
	private UsersRepository usersRepo;

	@Test
	public void saveUsers() {
		Users users = new Users();

		users.setUserName("Martin");
		users.setUserEmail("martin@gmail.com");
		users.setEmployeeCount(450);
		users.setUsersRole(UsersRole.CLIENT);
		users.setFloors(null);

		assertEquals(users, usersRepo.save(users));
	}

	@Test
	public void findByIdTest() {
		Optional<Users> opt_users = usersRepo.findById(62);
		if (opt_users.isPresent()) {
			Users user = opt_users.get();
			assertEquals(62, user.getUserId());
		} else {
			fail("User with id not found");
		}
	}

	@Test
	public void findAllAdminTest() {
		List<Users> users = usersRepo.findAll();
		for (Users u : users) {
			if (u.getUsersRole() == UsersRole.ADMIN) {
				assertEquals(UsersRole.ADMIN, u.getUsersRole());
				continue;
			} else {
				fail("Users with role ADMIN not found");
			}
		}
	}

	@Test
	public void findAllClientsTest() {
		List<Users> users = usersRepo.findAll();
		for (Users u : users) {
			if (u.getUsersRole() == UsersRole.CLIENT) {
				assertEquals(UsersRole.CLIENT, u.getUsersRole());
				continue;
			} else {
				fail("Users with role CLIENT not found");
			}
		}
		return;
	}

	@Test
	public void updateUsersTest() {

		Users users = new Users();

		users.setUserId(132);
		users.setUserName("Mark Antony");
		users.setUserEmail("mark_antony@gmail.com");
		users.setEmployeeCount(300);
		users.setUsersRole(UsersRole.CLIENT);
		users.setFloors(null);

		assertEquals(users.toString(), usersRepo.save(users).toString());
	}

}