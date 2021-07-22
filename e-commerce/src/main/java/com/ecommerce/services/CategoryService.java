package com.ecommerce.services;

import java.util.List;

import com.ecommerce.entities.Category;


public interface CategoryService {
	
	public Category addCategory(Category category); 
	public List<Category> fetchCategories();
	public Category updateCategory(Category category);
	public Category fetchCategory(int id);
	public void removeCategory(int id);
}
