package com.project_2;

import java.security.MessageDigest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project_2.dao.ProductsDAO;
import com.project_2.dao.UserDAO;
import com.project_2.model.Products;
import com.project_2.model.User;

@Component
public class DataLoader {

	@Autowired // auto create object
	private UserDAO userDao;

	@Autowired
	private ProductsDAO productsDao;

	@PostConstruct
	public void init() {
		// init code goes here
		// CREATE USER
		userDao.save(new User("aa", encryptPassword("a"), "aa@yahoo.com", "Thanh", "Huynh", "111 aaa, irving, tx 75060",
				"555-555-5555", "What is Your old Phone Number?", "aaa", "User"));
		userDao.save(new User("a", encryptPassword("a"), "a@yahoo.com", "Thanh", "Huynh", "111 aaa, irving, tx 75060",
				"555-555-5555", "What is Your old Phone Number?", "aaa", "Admin"));

		// CREATE PRODUCT
		productsDao.save(new Products(0, "Donkey", 12.0, "05 Oct 2019", "Plat", 23, 9.0f, "PC",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg"));

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
