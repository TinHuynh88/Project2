package com.project_2.service.impl;

import java.security.MessageDigest;

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
		//System.out.println("TEST= "+user);
		User user1 = userDao.userLogin(user.getUserName(), user.getPassword());
		//System.out.println("TEST 1= "+user1);
		if (user1 != null && user1.getRole().equals("User")) {
			return user1;
		} else {
			System.out.println("User is not found -" + user1);
		}

		return user1;
	}

	@Override
	public User forgotPassword(User user) {
		
		User user1 = userDao.userLogin(user.getUserName(), user.getPassword());
		if(user1 != null && user1.getRole().equals("User") && user1.getSecurityQuestion().equals("question") && user1.getSecurityAnswer().equals("answer")) {
			user1.setPassword(encryptPassword(user.getPassword()));
		}
		return null;
	}
	
	/////////////////////////////////////////////////////
	public String encryptPassword(String password) {
		StringBuffer message = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] hash = md.digest(password.getBytes("UTF-8"));

			for (byte w : hash) {
				message.append(String.format("%02x", w));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return message.toString();

	}

}
