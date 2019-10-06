package com.project_2.service.impl;

import java.util.List;

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
		// EMPTY CONSTRUCTOR BUSINESS STANDARD
	}

	@Override
	public Products createProduct(Products product) {
		return productsDao.save(product);
	}

	@Override
	public void deleteProduct(Products product) {
		productsDao.delete(product);		
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
		/* List<Products> prodList = new ArrayList<Products>(); */
		productsDao.findAll().forEach( prod -> {
			if ( prod.getProductName()!=null && prod.getProductName().equals(product.getProductName())) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	@Override
	public List<Products> getProductsBySystem(Products product) {
		/* List<Products> prodList = new ArrayList<Products>(); */
		productsDao.findAll().forEach( prod -> {
			if ( prod.getSystem()!=null && prod.getSystem().equals(product.getSystem())) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	@Override
	public List<Products> getProductsByCategory(Products product) {
		/* List<Products> prodList = new ArrayList<Products>(); */
		productsDao.findAll().forEach( prod -> {
			if ( prod.getCategory()!=null && prod.getCategory().equals(product.getCategory())) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	@Override
	public List<Products> getProductsByRating(Products product) {
		/* List<Products> prodList = new ArrayList<Products>(); */
		productsDao.findAll().forEach( prod -> {
			if ( prod.getRating()!=0.0f && prod.getRating() == product.getRating()) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	@Override
	public List<Products> getProductsByReleaseDate(Products product) {
		/* List<Products> prodList = new ArrayList<Products>(); */
		productsDao.findAll().forEach( prod -> {
			if ( prod.getCategory()!=null && prod.getCategory().equals(product.getCategory())) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	@Override
	public List<Products> getProductsByPrice(Products product) {
		productsDao.findAll().forEach( prod -> {
			if ( prod.getProductPrice()!=0.0d && prod.getProductPrice() == product.getProductPrice()) {
				this.prodList.add(prod);
			}
		});
		return prodList;
	}

	/*
	 * @Override public Products createProducts(Products product) { return
	 * productsDao.save(product); }
	 * 
	 * @Override public void deleteProducts(long productId) {
	 * productsDao.deleteById(productId); }
	 */
	
}
