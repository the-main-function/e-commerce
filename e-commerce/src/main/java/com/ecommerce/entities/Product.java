package com.ecommerce.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int productId;
	
	private String brand;
	
	private String model;
	
	private double price;
	
	@ManyToOne
	private Category category;

	private String description;
	
	@ElementCollection
	private List<String> imageNames;

	public Product() {
	}

	public Product(int productId, String brand, String model, double price, Category category, String description,
			List<String> imageNames) {
		this.productId = productId;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.category = category;
		this.description = description;
		this.imageNames = imageNames;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImageNames() {
		return imageNames;
	}

	public void setImageNames(List<String> imageNames) {
		this.imageNames = imageNames;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", category=" + category + ", description=" + description + ", imageNames=" + imageNames + "]";
	}

}
