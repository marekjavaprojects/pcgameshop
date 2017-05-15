package com.pcgameshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcgameshop.dao.ProductDAO;
import com.pcgameshop.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int productId) {
		return productDAO.getProductById(productId);
	}

}
