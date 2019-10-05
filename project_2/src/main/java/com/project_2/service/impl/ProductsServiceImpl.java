package com.project_2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project_2.dao.ProductsDAO;
import com.project_2.model.Products;
import com.project_2.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsDAO productsDao;
	private List<Products> prodList;
	
	public ProductsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Products createProduct(Products product) {
		return productsDao.save(product);
	}

	@Override
	public void deleteProduct(long productId) {
		productsDao.deleteById(productId);		
	}

	@Override
	public Products updateProduct(Products product) {
		return productsDao.save(product);
	}

	@Override
	public List<Products> getAllProducts() {
		return productsDao.findAll();
	}

	@Override
	@Query
	public Products getProductsById(long productId) {
		return productsDao.findById(productId).get();
	}

	@Override
	public List<Products> getProductsByName(Products product) {
		List<Products> prodList = new ArrayList<>();
		productsDao.findAll().forEach( prod -> {
			if ( prod.getProductName()!=null && prod.getProductName() == product.getProductName()) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	@Override
	public List<Products> getProductsBySystem(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getProductsByCategory(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getProductsByRating(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getProductsByReleaseDate(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getProductsByPrice(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Products createProducts(Products product) { return
	 * productsDao.save(product); }
	 * 
	 * @Override public void deleteProducts(long productId) {
	 * productsDao.deleteById(productId); }
	 */
	
}
