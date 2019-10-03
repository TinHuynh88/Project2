<<<<<<< HEAD
package com.project_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project_2.model.User;
import com.project_2.service.AdminUsersService;

@CrossOrigin 
@RestController
public class UserController {
	@Autowired
	private AdminUsersService service;
	
	@PostMapping("/createUser") 
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}
}
=======
package com.project_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project_2.model.User;
import com.project_2.service.Project_2Service;

@CrossOrigin 
@RestController
public class UserController {
	@Autowired
	private Project_2Service service;
	
	@PostMapping("/createUser") 
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}
}
>>>>>>> 8d2e8dcb720ae5ee1cc2e84510eba218bebd4b32
