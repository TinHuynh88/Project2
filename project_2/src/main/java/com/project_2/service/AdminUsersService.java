
package com.project_2.service;

import java.util.List;

import com.project_2.model.User;

public interface AdminUsersService {

	// User page HERE
	public User createUser(User user);
	public List<User> getAllUsers();
<<<<<<< HEAD
	
	// Admin page HERE
	public User adminLogin(User user);
=======
	public User getUserByName(String userName);
	
	// Admin page HERE
	public User adminLogin(User user);
	public void adminUserDelete(String userName);
>>>>>>> test-master
	
}
