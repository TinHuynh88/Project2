
package com.project_2.controller;

import java.security.MessageDigest;
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

import com.project_2.model.Transaction;
import com.project_2.model.User;
import com.project_2.service.AdminUsersService;


@CrossOrigin
@RestController
public class AdminController {
	@Autowired
	private AdminUsersService service;

	@Autowired
	private HttpServletRequest request;
 
	private HttpSession httpSession;

	@GetMapping("/getSession")
	public List<String> getSessions() {
		try {
			@SuppressWarnings("unchecked")
			List<String> messages = (List<String>) httpSession.getAttribute("USERNAME_SESSION");
//			System.out.println("session = " + httpSession.getId());
//			System.out.println("Test getSession:" + messages);
			return messages;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/adminLogin")
	public User adminLogin(@RequestBody User user) {
		List<String> messages = new ArrayList<>();
		user.setPassword(encryptPassword(user.getPassword()));
		User user1 = service.adminLogin(user);
		if (user1 != null) {
			messages.add(user1.getUserName());
			messages.add(user1.getRole());
			this.httpSession = request.getSession();
			this.httpSession.setAttribute("USERNAME_SESSION", messages);
//System.out.println("After add session: "+getSessions());
		}
		return user1;
	}

	@GetMapping("/adminHome")
	public void adminHome() {
		// @SuppressWarnings("unchecked")
		List<String> messages = getSessions();
		if (messages == null) {
			System.out.println("Admin Home null sesstion");
		} else {
			System.out.println("admin home session: " + messages);
		}
	}
	
	@DeleteMapping("/adminUser/{username}")
	public void deleteUserByUsername(@PathVariable String username) {
		System.out.println("Delete: "+username);
		service.adminUserDelete(username);
	}
	
	@GetMapping("/adminUser/{username}")
	public void getUserByUsername(@PathVariable String username) {
		System.out.println("Delete: "+username);
		service.getUserByName(username);
	}
	
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
