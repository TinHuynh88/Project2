package com.project_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project_2.model.Products;
import com.project_2.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

	@Query(value="Select * from user where (user_name=:userName and password=:password)", nativeQuery = true)
	User adminLogin(@Param("userName") String userName, @Param("password") String password);
	
	@Query(value="Select * from user where (user_name=:userName and password=:password)", nativeQuery = true)
	User userLogin(@Param("userName") String userName, @Param("password") String password);
	
	@Query(value="select * from user where (lower(user_name) like :search "
			+ "or lower(password) like :search or lower(email) like :search "
			+ "or concat(lower(first_name) ,' ', lower(last_name)) like :search "
			+ "or lower(address) like :search or lower(phone) like :search "
			+ "or lower(security_question) like :search "
			+ "or lower(security_answer) like :search)", nativeQuery = true)
	List<User> generalSearchUser(@Param("search") String search);
	
}
