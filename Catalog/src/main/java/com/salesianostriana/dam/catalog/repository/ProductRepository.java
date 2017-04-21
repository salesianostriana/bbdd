package com.salesianostriana.dam.catalog.repository;

import java.util.List;

import com.salesianostriana.dam.catalog.model.Product;

public interface ProductRepository {

	public List<Product> findAll();
	
	public Product findById(long id);
	
	
}
