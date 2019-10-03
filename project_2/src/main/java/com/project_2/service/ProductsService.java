package com.project_2.service;

import com.project_2.model.Product;

public interface ProductsService {
	
	public Product createProduct(Product product);
	public Product deleteProduct(Product product);
	public Product updateProduct(Product product);

}
