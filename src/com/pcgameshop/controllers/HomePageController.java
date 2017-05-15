package com.pcgameshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcgameshop.entity.Product;
import com.pcgameshop.service.ProductService;

@Controller
public class HomePageController {	
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	@GetMapping
	public String showHomePage(Model model) {
		
		List<Product> products = productService.getProducts();
		
		model.addAttribute("products", products);
		
		return "homepage";
		
	}

}
