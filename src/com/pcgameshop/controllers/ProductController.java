package com.pcgameshop.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcgameshop.entity.Product;
import com.pcgameshop.service.ProductService;

@Controller
public class ProductController {

	private boolean showAll;
	private boolean showProductsByCategory;
	private boolean showLatestProducts;
	private boolean showFoundProducts;

	@Autowired
	ProductService productService;

	@GetMapping("products/allProducts")
	public String showAllProducts(Model model) {

		showAll = true;
		List<Product> allProducts = productService.getProducts();
		Set<String> categories = productService.fetchCategoriesFromProducts(productService.getProducts());

		model.addAttribute("allProducts", allProducts);
		model.addAttribute("categories", categories);
		model.addAttribute("showAll", showAll);

		return "shop-homepage";
	}

	@GetMapping("/products/{category}")
	public String showProductsByCategory(@PathVariable("category") String category, Model model) {

		showProductsByCategory = true;
		List<Product> productsByCategory = productService.getProductsByCategory(category);
		Set<String> categories = productService.fetchCategoriesFromProducts(productService.getProducts());

		model.addAttribute("productsByCategory", productsByCategory);
		model.addAttribute("categories", categories);
		model.addAttribute("showProductsByCategory", showProductsByCategory);

		return "shop-homepage";
	}

	@GetMapping("products/search")
	public String searchProductsByName(@RequestParam(value = "productName") String productName, Model model) {
		Set<String> categories = productService.fetchCategoriesFromProducts(productService.getProducts());

		if (productName.trim().compareTo("") == 0) {
			model.addAttribute("categories", categories);
			model.addAttribute("showFoundProducts", showFoundProducts);
			return "shop-homepage";

		}
		showFoundProducts = true;
		List<Product> productsByName = productService.searchProductsByName(productName);

		model.addAttribute("productsByName", productsByName);
		model.addAttribute("categories", categories);
		model.addAttribute("showFoundProducts", showFoundProducts);
		model.addAttribute("productName", productName);

		return "shop-homepage";
	}

}
