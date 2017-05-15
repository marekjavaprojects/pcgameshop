package com.pcgameshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcgameshop.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {

		Session currentSession = sessionFactory.getCurrentSession();

		// create a query .. sort by last name
		Query<Product> query = currentSession.createQuery("from Product", Product.class);

		// execute query and get result list
		List<Product> products = query.getResultList();

		return products;
	}

	@Override
	public Product getProductById(int productId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Product product = currentSession.get(Product.class, productId);

		return product;
	}

}
