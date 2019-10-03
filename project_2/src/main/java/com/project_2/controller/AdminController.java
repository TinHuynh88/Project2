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
import com.project_2.service.Project_2Service;

@CrossOrigin 
@RestController
public class AdminController {
	@Autowired
	private Project_2Service service;
	
	@Autowired
	private HttpServletRequest request;
//	@Autowired 
//	 private HttpSession httpSession;
	
//	@PostMapping("/adminLogin") 
//	public User adminLogin(@RequestBody User user) {
//		return service.adminLogin(user);
//	}
	@GetMapping("/getSession")
	public List<String> getSessions() {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("USERNAME_SESSION");
//		if (messages == null) {
//			messages = new ArrayList<>();
//			request.getSession().setAttribute("USERNAME_SESSION", messages);
			System.out.println("Test getSession:"+messages);
//		}
		return messages;
	}
//	@GetMapping("/getSession")
//	public User getSessions(HttpSession httpSession) {
////		@SuppressWarnings("unchecked")
////		List<String> messages = (List<String>) request.getSession().getAttribute("USERNAME_SESSION");
//		User user= new User();
////		httpSession = request.getSession(false);
//				if (httpSession.getAttribute("user") == null) {
////			messages = new ArrayList<>();
////			request.getSession().setAttribute("USERNAME_SESSION", messages);
//			System.out.println("Test getSession:");
//		}else {
//			user= (User) httpSession.getAttribute("user");
//		}
//		return user;
//	}
//	@PostMapping("/adminLogin") 
//	public User adminLogin(@RequestBody User user,HttpSession httpSession) {
//		
////		@SuppressWarnings("unchecked")
////		List<String> messages = (List<String>) request.getSession().getAttribute("USERNAME_SESSION");
////		if (messages == null) {
////			List<String> messages = new ArrayList<>();
////			request.getSession().setAttribute("USERNAME_SESSION", messages);
////			System.out.println("---------------\nTest session login:"+messages);
////		}
//		User user1=service.adminLogin(user);
//		if(user1!=null) {
//			
//System.out.println("Login test 1");
//	//	httpSession=request.getSession();
//System.out.println("Login test 2");
//		httpSession.setAttribute("User", user1);
//System.out.println("Login test 3");
//			
//}
//		System.out.println("Login test 4"+user1);
//		return user1;
//	}
	@PostMapping("/adminLogin") 
	public User adminLogin(@RequestBody User user) {
		
//		@SuppressWarnings("unchecked")
//		List<String> messages = (List<String>) request.getSession().getAttribute("USERNAME_SESSION");
//		if (messages == null) {
			List<String> messages = new ArrayList<>();
//			request.getSession().setAttribute("USERNAME_SESSION", messages);
			System.out.println("---------------\nTest session login:"+messages);
//		}
		User user1=service.adminLogin(user);
		if(user1!=null) {
		messages.add(user1.getUserName());
		messages.add(user1.getRole());
		request.getSession().setAttribute("USERNAME_SESSION", messages);
//		@SuppressWarnings("unchecked")
//		List<String> messages1 = (List<String>) request.getSession().getAttribute("USERNAME_SESSION");
		System.out.println("After add session: "+getSessions());
		}
		return user1;
	}
//	@GetMapping("/adminHome")
//	public void adminHome(HttpSession httpSession) {
//		//@SuppressWarnings("unchecked")
//		User messages = getSessions(httpSession);
//		if (messages == null) {
//			System.out.println("Admin Home null sesstion");
//		}else {
//			System.out.println("admin home session: "+messages);
//		}
////		messages.add(msg);
////		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
////		return "redirect:/";
//	}
	@GetMapping("/adminHome")
	public void adminHome() {
		//@SuppressWarnings("unchecked")
		List<String> messages = getSessions();
		if (messages == null) {
			System.out.println("Admin Home null sesstion");
		}else {
			System.out.println("admin home session: "+messages);
		}
//		messages.add(msg);
//		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//		return "redirect:/";
	}
}
