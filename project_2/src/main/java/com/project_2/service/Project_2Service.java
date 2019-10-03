package com.project_2.service;

import java.util.List;

import com.project_2.model.User;

public interface Project_2Service {

	// User page HERE
	public User createUser(User user);
	public List<User> getAllUsers();
	
	// Admin page HERE
	public User adminLogin(User user);
	
}
