package com.pcgameshop.dao;

import java.util.List;

import com.pcgameshop.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();

	public Product getProductById(int productId);

	public List<Product> getFourLatestProducts();
		
	public List<Product> getProductsByCategory(String category);

	public List<Product> searchProductsByName(String productName);


}
