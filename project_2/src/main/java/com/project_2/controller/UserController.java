package com.project_2.controller;


import java.util.ArrayList;

import java.security.MessageDigest;
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



import com.project_2.service.UserService;
import com.project_2.model.Order;
import com.project_2.model.Products;
import com.project_2.model.Transaction;
import com.project_2.model.User;
import com.project_2.service.AdminUsersService;
import com.project_2.service.OrderService;
import com.project_2.service.ProductsService;
import com.project_2.service.TransactionService;


@CrossOrigin 
@RestController
public class UserController {
	@Autowired
	private AdminUsersService service;

	@Autowired
	private UserService service1;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductsService productService;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private HttpServletRequest request;
	
	private HttpSession httpSession;
	
	@GetMapping("/getUserSession")
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
	
	
	@PostMapping("/userLogin")
	public User userLogin(@RequestBody User user) {
		System.out.println(user);
		List<String> message1 = new ArrayList<>();
		user.setPassword(encryptPassword(user.getPassword()));
		User user1 = service1.userLogin(user);
		if(user1 != null) {
			message1.add(user1.getUserName());
			message1.add(user1.getRole());
			this.httpSession = request.getSession();
			this.httpSession.setAttribute("USERNAME_SESSION", message1);
		}
		
		return user1;
	}
	
	@PostMapping("/userRegister") 
	public User userRegister(@RequestBody User user) {
		user.setPassword(encryptPassword(user.getPassword()));
		return service1.userRegister(user);
	}
	
	@PostMapping("/createUser") 
	public User createUser(@RequestBody User user) {
		user.setPassword(encryptPassword(user.getPassword()));

		return service.createUser(user);

	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}
	
	@PostMapping("/createProduct")
	public Products createProduct(@RequestBody Products product) {
		return productsService.createProduct(product);
	}
	
	@GetMapping("/products")
	public List<Products> getAllProducts() {
		return productsService.getAllProducts();
	}

	
	@PostMapping("/createTransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		
		return transactionService.createTransaction(transaction);
	}
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
    @PostMapping("/createOrder")
	public Order createOrder (@RequestBody Order order) {
		return orderService.createOrder(order);
	}
  //////////////Test  
    @PostMapping("/create")
	public Order create (@RequestBody Order order) {
		// implement here
		return orderService.createOrder(order);
	}
    
 ///////////////////////////////////////////   
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
    	return orderService.getAllOrders();
    };
    
    @GetMapping("/ordersByTransactionId/{id}")
    public List<Order> getOrdersByTransactionId(@PathVariable long transactionId) {
        return orderService.getOrdersByTransactionId(transactionId);
    };
    @GetMapping("/ordersByProductId/{id}")
    public List<Order> getOrdersByProductId(@PathVariable long productId) {
        return orderService.getOrdersByProductId(productId);
    };
       
    @GetMapping("/userLogout")
	public void adminLogout() {
		System.out.println("User Logout");
		this.httpSession.invalidate();
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
