package com.pcgameshop.service;

import java.util.List;

import com.pcgameshop.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public Product getProductById(int productId);

}
