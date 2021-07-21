package com.ecommerce.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ecommerce.entities.Category;

@Component
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "CAT_NAME_EMPTY_01","enter a valid category name");
		
		if(!category.getImage().getOriginalFilename().isEmpty()) {
			if(category.getImage().getSize() > 4000000) {
				errors.rejectValue("image","CAT_IMAGE_SIZE_EXCEEDED_03","image cannot be greater than 4MB" );
			}
		}
		
	}

}
