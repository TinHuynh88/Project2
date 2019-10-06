package com.project_2.service;

import java.util.List;
import com.project_2.model.Products;

public interface ProductsService {
	
	public Products createProduct(Products product);
	public void deleteProduct(Products product);
	public Products updateProduct(Products product);
	public List<Products> getAllProducts();
	public Products getProductsById(long productId);
	public List<Products> getProductsByName(Products product);
	public List<Products> getProductsBySystem(Products product);
	public List<Products> getProductsByCategory(Products product);
	public List<Products> getProductsByRating(Products product);
	public List<Products> getProductsByReleaseDate(Products product);
	public List<Products> getProductsByPrice(Products product);

}

