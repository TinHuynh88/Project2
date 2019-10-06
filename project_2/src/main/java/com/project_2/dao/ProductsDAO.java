package com.project_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project_2.model.Products;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Long> {
	@Query(value="select * from Products where (product_id like :search "
			+ "or lower(product_name) like :search or product_price like :search "
			+ "or release_date like :search or lower(category) like :search "
			+ "or quantity like :search or rating like :search "
			+ "or lower(system) like :search)", nativeQuery = true)
	List<Products> generalSearchProduct(@Param("search") String search);
	

}
