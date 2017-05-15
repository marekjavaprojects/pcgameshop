package com.pcgameshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "category")
	private String category;

	@Column(name = "unit_price")
	private Double unitPrice;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "path_to_image")
	private String pathToImage;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPathToImage() {
		return pathToImage;
	}

	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
	}

	public int getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", pathToImage=" + pathToImage + "]";
	}
	
}
