package com.salesianostriana.dam.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepo;
	
	
	public User loginByEmailAndPassword(String email, String password) {
		
		User usuario = userRepo.findFirstByEmailAndPassword(email, password);
		
		return usuario;
		
	}

}
