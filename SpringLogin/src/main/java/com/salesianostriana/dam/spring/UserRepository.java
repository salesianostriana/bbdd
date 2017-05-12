package com.salesianostriana.dam.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findFirstByEmailAndPassword(String email, String password);

}
