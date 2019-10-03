package com.project_2.service;

import java.util.List;

import com.project_2.model.Products;

public interface ProductsService {
	
	public Products createProducts(Products products);
	public Products deleteProducts(Products products);
	public Products updateProducts(Products products);
	public List<Products> getAllProductss();
	public List<Products> getProductssById(Products products);
	public List<Products> getProductssByName(Products products);
	public List<Products> getProductssBySystem(Products products);
	public List<Products> getProductssByCategory(Products products);
	public List<Products> getProductssByRating(Products products);
	public List<Products> getProductssByReleaseDate(Products products);
	public List<Products> getProductssByPrice(Products products);

}
