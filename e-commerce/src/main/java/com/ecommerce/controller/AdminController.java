package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entities.Category;
import com.ecommerce.services.CategoryService;
import com.ecommerce.validators.CategoryValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryValidator categoryValidator;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/home")
	public String homePage() {
		return "admin_home";
	}
	
	@RequestMapping("/admin-dashboard")
	public String adminDashboard() {
		return "adminDashboard";
	}
	
	@RequestMapping("/add-category-form")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "adminCategoryAddForm";
	}
	
	@PostMapping("/add-category")
	public String addCategory(@ModelAttribute("category") Category category, BindingResult result) 
							throws IllegalStateException, IOException{
		
		System.out.println("admin/add-category");
		
		categoryValidator.validate(category,result);
		if(result.hasErrors()) {
			return "adminCategoryAddForm";
		}
		
		//image upload code
		MultipartFile file = category.getImage();
		
		if(!file.getOriginalFilename().isEmpty()) {
			String orignalFileName = file.getOriginalFilename();
			int indexOfDot = orignalFileName.indexOf(".");
			String extension = orignalFileName.substring(indexOfDot);
			String imageName = category.getName() + extension;
			file.transferTo(new File("F:\\uploads_ecommerce\\category_images\\"+category.getName()+extension));
			//setting imageName for retrieval purpose
			category.setImageName(imageName);
		}

		categoryService.addCategory(category);
		return "success";
	}
	
	@ExceptionHandler(SizeLimitExceededException.class)
	public String imageSizeLarge() {
		return "adminCategoryAddForm";
	}
}
