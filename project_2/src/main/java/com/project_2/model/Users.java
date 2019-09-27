package com.project_2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Users {
	@Id
	private String username;
	private String password;
	private String email;
	private String first_name;
	private String last_name;
	private String address;
	private String phone;
	private String security_question;
	private String security_answer;
	private String role;
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", email=" + email + ", first_name="
				+ first_name + ", last_name=" + last_name + ", address=" + address + ", phone=" + phone
				+ ", security_question=" + security_question + ", security_answer=" + security_answer + ", role=" + role
				+ "]";
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password, String email, String first_name, String last_name, String address,
			String phone, String security_question, String security_answer, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone = phone;
		this.security_question = security_question;
		this.security_answer = security_answer;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
