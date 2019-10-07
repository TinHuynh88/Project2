package com.project_2;

import java.security.MessageDigest;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project_2.dao.OrderDAO;
import com.project_2.dao.ProductsDAO;
import com.project_2.dao.TransactionDAO;
import com.project_2.dao.UserDAO;
import com.project_2.model.Order;
import com.project_2.model.Products;
import com.project_2.model.Transaction;
import com.project_2.model.User;

@Component
public class DataLoader {

	@Autowired // auto create object
	private UserDAO userDao;

	@Autowired
	private ProductsDAO productsDao;
	
	@Autowired
	private TransactionDAO transactionDao;
	@Autowired
	private OrderDAO orderDao;

	@PostConstruct
	public void init() {
		// init code goes here
		// CREATE USER
		User u1 = new User("aaa", encryptPassword("a"), "aaa@yahoo.com", "Thanhaa", "Huynhaa", "111 aaa, irving, tx 75060",
				"666-555-5555", "What is Your old Phone Number?", "aaa", "User");
		userDao.save(u1);
		userDao.save(new User("aa", encryptPassword("a"), "aa@yahoo.com", "Thanh", "Huynh", "111 aaa, irving, tx 75060",
				"555-555-5555", "What is Your old Phone Number?", "aaa", "User"));
		userDao.save(new User("a", encryptPassword("a"), "a@yahoo.com", "Thanh", "Huynh", "111 aaa, irving, tx 75060",
				"555-555-5555", "What is Your old Phone Number?", "aaa", "Admin"));

		// CREATE PRODUCT
		
		Products p1=new Products(0, "Mario", 12.0, "2011-10-31", "Plat", 23, 9.0f, "PC",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg");

		productsDao.save(p1);
		productsDao.save(new Products(0, "Donkey", 12.0, "2013-10-31", "Plat", 23, 9.0f, "PC",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg"));

		productsDao.save(new Products(0, "Don", 23.0, "2014-10-31", "Plat", 23, 9.0f, "PS4",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg"));

		// CREATE TRANSACTION
		Date date = new Date();
		System.out.println(date);
		Transaction t1=new Transaction(0, date,30.3,u1);
		transactionDao.save(t1);
		transactionDao.save(new Transaction(0,date,30,u1));
		transactionDao.save(new Transaction(0,date,30,u1));
		
		// CREATE ORDER
		Order o1 = new Order(0,t1,p1,2,100.0);
		Order o2 = new Order(0,t1,p1,2,100.0);
		orderDao.save(o1);
		orderDao.save(o2);
		
	
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
