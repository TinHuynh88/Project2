package com.project_2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.project_2.service.UserService;

@CrossOrigin 
@RestController
public class UserController {
	@Autowired
	private AdminUsersService service;
	
	@Autowired
	private UserService service1;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession httpSession;
	
	public List<String> getSession(){
		
		try {
		@SuppressWarnings("unchecked")
		List<String> message = (List<String>) httpSession.getAttribute("USERNAME_SESSION");
		return message;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	
	@PostMapping("/login")
	public User userLogin(User user) {
		
		List<String> message1 = new ArrayList<>();
		User user1 = service1.userLogin(user);
		if(user1 != null) {
			message1.add(user1.getUserName());
			message1.add(user1.getRole());
			this.httpSession = request.getSession();
			this.httpSession.setAttribute("USERNAME_SESSION", message1);
		}
		
		return user;
	}
	
	@PostMapping("/userRegister") 
	public User userRegister(@RequestBody User user) {
		return service1.userRegister(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}
}

