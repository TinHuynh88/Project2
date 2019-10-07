package com.project_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_2.dao.UserDAO;
import com.project_2.model.User;
import com.project_2.service.AdminUsersService;

@Service
public class AdminUsersServiceImpl implements AdminUsersService {

	@Autowired //auto create object
	private UserDAO userDao;
	
	@Override
	public User adminLogin(User user) {
		User user1 = userDao.adminLogin(user.getUserName(), user.getPassword());
			if(user1!=null && user1.getRole().equals("Admin")) {
				return user1;
			}else {
				System.out.println("User is not found -"+user1);
			}
		
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void adminUserDelete(String userName) {
		userDao.deleteById(userName);
		
	}

	@Override
	public User getUserByUsername(String userName) {
		return userDao.findById(userName).get();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("UpdateDAO: "+user);
		return  userDao.save(user);
	}

	@Override
	public List<User> generalSearchUser(String search) {
		// TODO Auto-generated method stub
		return userDao.generalSearchUser("%"+search.toLowerCase()+"%");
	}


}
