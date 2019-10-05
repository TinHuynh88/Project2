package com.project_2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_2.dao.UserDAO;
import com.project_2.model.User;
import com.project_2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public User userRegister(User user) {
		User user1;
		try {
		user1=userDao.save(user);
		}catch(Exception e) {
			user1=null;
		}
		// TODO Auto-generated method stub
		return user1;
	}

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		System.out.println("TEST= "+user);
		User user1 = userDao.userLogin(user.getUserName(), user.getPassword());
		System.out.println("TEST 1= "+user1);
		if (user1 != null && user1.getRole().equals("User")) {
			return user1;
		} else {
			System.out.println("User is not found -" + user1);
		}

		return user1;
	}

}
