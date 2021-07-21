package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
}
