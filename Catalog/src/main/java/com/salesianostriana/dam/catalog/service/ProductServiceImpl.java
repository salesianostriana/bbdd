package com.salesianostriana.dam.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.catalog.model.Product;
import com.salesianostriana.dam.catalog.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> obtenerProductos() {
		return repo.findAll();
	}
	
	public Product obtenerUnProducto(long id) {
		return repo.findById(id);
	}
	
	

}
