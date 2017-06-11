package com.pcgameshop.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.pcgameshop.entity.Product;
import com.pcgameshop.service.ProductService;

@Controller
public class HomePageController {
	
	private String productListLabel;

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String showHomePageWithFourLatestProducts(Model model) {

		List<Product> latestFourProducts = productService.getFourLatestProducts();
		Set<String> categories = productService.fetchCategoriesFromProducts(productService.getProducts());
		productListLabel = "Latest Games!";

		model.addAttribute("products", latestFourProducts);
		model.addAttribute("categories", categories);
		model.addAttribute("productListLabel", productListLabel);
		return "shop-homepage";
	}
}
