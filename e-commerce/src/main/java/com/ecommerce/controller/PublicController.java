package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/admin-login-page")
	public String adminLoginForm() {
		return "adminLoginPage";
	}
	
	@RequestMapping("/user-login-page")
	public String userLoginForm() {
		return "userLoginPage";
	}
}
