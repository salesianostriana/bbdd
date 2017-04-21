package com.salesianostriana.dam.catalog.service;

import java.util.List;

import com.salesianostriana.dam.catalog.model.Product;

public interface ProductService {
	
	public List<Product> obtenerProductos();
	
	public Product obtenerUnProducto(long id);
	

}
