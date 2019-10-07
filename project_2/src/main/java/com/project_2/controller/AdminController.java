
package com.project_2.controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project_2.model.Products;
import com.project_2.model.Transaction;
import com.project_2.model.User;
import com.project_2.service.AdminUsersService;
import com.project_2.service.ProductsService;
import com.project_2.service.TransactionService;


@CrossOrigin
@RestController
public class AdminController {
	@Autowired
	private AdminUsersService service;
	@Autowired
	private ProductsService productService;
	@Autowired
	private TransactionService transService;

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
	

	@PostMapping("/adminCreateTransaction")
	public Transaction adminCreateTransaction() {
		Transaction transaction=null;
		return transaction;
	}

	@DeleteMapping("/adminUser/{username}")
	public void deleteUserByUsername(@PathVariable String username) {
		System.out.println("Delete: "+username);
		service.adminUserDelete(username);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteUserByUsername(@PathVariable long id) {
		System.out.println("Delete: "+id);
//		Products p= new Products();
//		p.setProductId(id);
		productService.deleteProductById(id);
	}
	
	@GetMapping("/searchProducts/{search}")
	public List<Products> searchProducts(@PathVariable String search) {
		System.out.println("General__Search: "+search);
		return productService.getProductBySearch(search);
	}
	
	@GetMapping("/adminUser/{username}")
	public User getUserByUsername(@PathVariable String username) {
	//	System.out.println("Delete: "+username);
		User user=service.getUserByUsername(username);
		return user;
	}
	
	@PutMapping("/adminUpdateUser")
	public User updatetUserByUsername(@RequestBody User user) {
		System.out.println("update: "+user);
		try {
			user=service.updateUser(user);
		}catch(Exception e) {
			System.out.println("Update error:"+e.getMessage());
			user=null;
		}
		return user;
	}
	
	@PutMapping("/adminUpdateProduct")
	public Products updatetProductById(@RequestBody Products product) {
		System.out.println("update product: "+product);
		try {
			product = productService.updateProduct(product);
		}catch(Exception e) {
			System.out.println("Update error:"+e.getMessage());
			product=null;
		}
		return product;
	}
	
	@GetMapping("/adminLogout")
	public void adminLogout() {
		System.out.println("Admin Logout");
		this.httpSession.invalidate();
	}
	
	@GetMapping("/searchUsers/{search}")
	public List<User> searchUsers(@PathVariable String search) {
		System.out.println("General__Search: "+search);
		return service.generalSearchUser(search);
	}
	
	@GetMapping("/searchTransactions/{search}")
	public List<Transaction> searchTransactions(@PathVariable String search) {
		System.out.println("General__Search: "+search);
		return transService.generalSearchTransaction(search);
	}
	
	@PutMapping("/adminUpdatePassword")
    public User updatetUserByPassword(@RequestBody User user) {
        System.out.println("update: "+user);
        try {
            user.setPassword(encryptPassword(user.getPassword()));
            user=service.updateUser(user);
        }catch(Exception e) {
            System.out.println("Update error:"+e.getMessage());
            user=null;
        }
        return user;
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
