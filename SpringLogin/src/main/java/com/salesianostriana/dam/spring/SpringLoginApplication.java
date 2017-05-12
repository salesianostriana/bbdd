package com.salesianostriana.dam.spring;

import javax.servlet.Filter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoginApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demoData(UserRepository repo) {
		return (args) -> {
			if (repo.count() == 0) {
				User usuario = new User();
				usuario.setFullName("Luis Miguel Lopez");
				usuario.setEmail("luismi.lopez@salesianos.edu");
				usuario.setPassword("12345");
				repo.save(usuario);
			}
		};
	}
	
	
	@Bean
	public FilterRegistrationBean filterSecurityBean() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(securityFilter());
		registration.addUrlPatterns("/app/*");
		registration.setName("securityFilter");
		return registration;
	}
	
	@Bean(name="securityFilter")
	public Filter securityFilter() {
		return new SecurityFilter();
	}
	
	
}
