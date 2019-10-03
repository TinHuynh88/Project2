package com.project_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project_2.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

	@Query(value="Select * from user where (user_name=:userName and password=:password)", nativeQuery = true)
	User adminLogin(@Param("userName") String userName, @Param("password") String password);
	
	User userLogin(@Param("userName") String userName, @Param("password") String password);
}
