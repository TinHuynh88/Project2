package com.project_2.controller;

<<<<<<< HEAD
=======
import java.security.MessageDigest;
>>>>>>> test-master
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

<<<<<<< HEAD
import com.project_2.model.User;
import com.project_2.service.AdminUsersService;
=======
import com.project_2.model.Transaction;
import com.project_2.model.User;
import com.project_2.service.AdminUsersService;
import com.project_2.service.TransactionService;
>>>>>>> test-master

@CrossOrigin 
@RestController
public class UserController {
	@Autowired
	private AdminUsersService service;
<<<<<<< HEAD
	
	@PostMapping("/createUser") 
	public User createUser(@RequestBody User user) {
=======
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/createUser") 
	public User createUser(@RequestBody User user) {
		user.setPassword(encryptPassword(user.getPassword()));
>>>>>>> test-master
		return service.createUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}
<<<<<<< HEAD
=======
	
	@PostMapping("/createTransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		
		return transactionService.createTransaction(transaction);
	}
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		
		return transactionService.getAllTransactions();
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
>>>>>>> test-master
}

