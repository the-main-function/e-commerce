package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Category;
import com.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> fetchCategories() {
		return (List<Category>)categoryRepository.findAll();
	}

	@Override
	public Category updateCategory(Category category) {
		Category existingCategory = categoryRepository.findById(category.getCategoryId()).get();
		existingCategory.setName(category.getName());
		existingCategory.setImageName(category.getImageName());
		return categoryRepository.save(existingCategory);
	}

	@Override
	public Category fetchCategory(int id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public void removeCategory(int id) {
		categoryRepository.deleteById(id);
	}

}
