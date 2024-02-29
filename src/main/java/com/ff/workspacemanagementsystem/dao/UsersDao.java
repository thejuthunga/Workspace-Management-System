package com.ff.workspacemanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.repository.UsersRepository;
import com.ff.workspacemanagementsystem.utility.UsersRole;

@Repository
public class UsersDao {

	@Autowired
	UsersRepository usersRepository;

	public Users save(Users user) {
		user.setFloors(new Floors());
		return usersRepository.save(user);
	}

	public Users find(int id) {
		Optional<Users> optional_users = usersRepository.findById(id);
		if (optional_users.isPresent()) {
			return optional_users.get();
		}
		else {
			throw new NullPointerException();
		}
	}

	public List<Users> findAllAdmin() {
		List<Users> users = usersRepository.findAll();
		List<Users> admins = new ArrayList<Users>();
		for (Users u : users) {
			if (u.getUsersRole() == UsersRole.ADMIN) {
				admins.add(u);
			}
		}
		return admins;
	}

	public List<Users> findAllClients() {
		List<Users> users = usersRepository.findAll();
		List<Users> clients = new ArrayList<Users>();
		for (Users u : users) {
			if (u.getUsersRole() == UsersRole.CLIENT) {
				clients.add(u);
			}
		}
		return clients;
	}

	public Users update(int id, Users user) {

		Users avl_user = find(id);
		if(avl_user.getUserId() == user.getUserId()) {
			return usersRepository.save(user);
		}
		else {
			return null;
		}
		
	}

	public void delete(int id) {
		Users user = find(id);
		usersRepository.delete(user);
	}

}
