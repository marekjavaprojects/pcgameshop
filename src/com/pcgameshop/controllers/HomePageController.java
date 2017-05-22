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

	private boolean showLatestProducts;

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String showHomePageWithFourLatestProducts(Model model) {

		showLatestProducts = true;
		List<Product> latestFourProducts = productService.getFourLatestProducts();
		Set<String> categories = productService.fetchCategoriesFromProducts(productService.getProducts());

		model.addAttribute("latestFourProducts", latestFourProducts);
		model.addAttribute("categories", categories);
		model.addAttribute("showLatestProducts", showLatestProducts);

		return "shop-homepage";
	}
}
