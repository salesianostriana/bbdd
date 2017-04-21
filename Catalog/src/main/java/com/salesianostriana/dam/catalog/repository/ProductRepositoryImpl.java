package com.salesianostriana.dam.catalog.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.catalog.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	List<Product> list;
	
	@PostConstruct
	public void init() {
		list = new ArrayList<Product>();
		
		list.add(new Product(1,"Cruzcampo", "Caja de 24 botellines Cruzcampo", 9.6));
		list.add(new Product(2,"Cruzcampo", "Caja de 12 botellines Cruzcampo", 5.4));
		list.add(new Product(3,"Paulaner", "Botellín 60cl Paulaner", 2.4));
		list.add(new Product(4,"Budweiser", "Caja de 6 botellines Budweiser", 6.3));
		list.add(new Product(5,"Franciskaner", "Botellín 60cl Franciskaner", 1.3));
		list.add(new Product(6,"Alhambra", "Caja de 6 botellines Alhambra 1925", 5.5));
		
		
	}
	
	public List<Product> findAll() {
		return list;
	}
	
	public Product findById(long id) {
		if (id >= 0 && id < list.size()) {
			return list.get((int) id-1);
		}
		
		return null;
	}
	
	

}
