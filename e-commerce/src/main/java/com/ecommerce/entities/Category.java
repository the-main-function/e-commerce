package com.ecommerce.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="category_details")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int categoryId;
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	@Column(name="image_name")
	private String imageName;
	
	@Transient
	private MultipartFile image;

	public Category() {
	}

	public Category(int categoryId, String name, List<Product> products, String imageName, MultipartFile image) {
		this.categoryId = categoryId;
		this.name = name;
		this.products = products;
		this.imageName = imageName;
		this.image = image;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", products=" + products + ", imageName="
				+ imageName + "]";
	}

	
}
