package com.ff.workspacemanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.Floors;
import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.exception.FloorsCountReachedException;
import com.ff.workspacemanagementsystem.exception.NoFloorsMatchedException;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.FloorsRepository;
import com.ff.workspacemanagementsystem.repository.UsersRepository;
import com.ff.workspacemanagementsystem.utility.UsersRole;

@Repository
public class UsersDao {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private FloorsRepository floorsRepository;

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private BranchDao branchDao;
	
	
	public Users save(Users user) {
		return usersRepository.save(user);
	}

	public Users findUserById(int id) {
		Optional<Users> optional_users = usersRepository.findById(id);
		if (optional_users.isPresent()) {
			return optional_users.get();
		} else {
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

		Users avl_user = findUserById(id);
		if (avl_user.getUserId() == user.getUserId()) {
			avl_user.setUserId(id);
			avl_user.setUserName(user.getUserName());
			avl_user.setUserEmail(user.getUserEmail());
			avl_user.setEmployeeCount(user.getEmployeeCount());
			avl_user.setUsersRole(user.getUsersRole());
			return usersRepository.save(avl_user);
		} else {
			return null;
		}

	}

	public void delete(int id) {
		Users user = findUserById(id);
		usersRepository.delete(user);
	}

	public void addFloorToClient(int a_id, int c_id, int b_id) {
		Users admin = findUserById(a_id);
		Users client = findUserById(c_id);
		
		Branch branch = branchDao.findBranch(b_id);
		List<Floors> floors = branch.getFloors();

		if(admin.getUsersRole() == UsersRole.ADMIN) {
			for (Floors f : floors) {
				if (branch.getFloorsCount() >= 1) {
					if (f.getNoOfWorkstations() >= client.getEmployeeCount()) {
						f.setUsers(client);
						f.setIsfloorAvailable(false);
						branch.setFloorsCount(branch.getFloorsCount() - 1);
						branchRepository.save(branch);
						floorsRepository.save(f);
						break;
					} else {
						throw new NoFloorsMatchedException("No floors matching with your requirements");
					}
				} else {
					throw new NullPointerException();
				}
			}
		}
	}

	public boolean removeClientFromFloor(int a_id, int f_id) {
		Floors floor = null;

		if (findUserById(a_id).getUsersRole() == UsersRole.ADMIN) {
			Optional<Floors> opt_floor = floorsRepository.findById(f_id);
			if (opt_floor.isPresent()) {
				floor = opt_floor.get();
				floor.setUsers(null);
				floor.setIsfloorAvailable(true);
				Branch branch = floor.getBranch();
				int f_count = branch.getFloorsCount();
				f_count++;
				branch.setFloorsCount(f_count);
				floor.setBranch(branch);
				floorsRepository.save(floor);
			} else {
				throw new FloorsCountReachedException("No clients in the floor to remove");
			}

			return true;
		} else {
			return false;
		}

	}
}
