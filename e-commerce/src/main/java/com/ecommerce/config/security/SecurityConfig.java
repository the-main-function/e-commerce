package com.ecommerce.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Configuration
	@Order(1)
	public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter{
			
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
				.antMatcher("/admin/**")
				.authorizeRequests()
				.anyRequest().hasRole("ADMIN")
				.and()
				.httpBasic();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth
				.inMemoryAuthentication().withUser("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN");
		}
		
	}
	
	@Configuration
	@Order(2)
	public static class UserSecurityConfig extends WebSecurityConfigurerAdapter{
			
		@Override
		protected void configure(HttpSecurity http) throws Exception {	
			http
				.antMatcher("/user/**")
				.authorizeRequests()
				.anyRequest().hasRole("USER")
				.and()
				.formLogin();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth
				.inMemoryAuthentication().withUser("normal_user")
				.password(passwordEncoder().encode("normal_user"))
				.roles("USER");
		}
		
	}

}
