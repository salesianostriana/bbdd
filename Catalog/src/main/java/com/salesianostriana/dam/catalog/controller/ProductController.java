package com.salesianostriana.dam.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.catalog.model.Product;
import com.salesianostriana.dam.catalog.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productos") 
	public String catalogoProductos(Model model) {
		
		model.addAttribute("prods", productService.obtenerProductos());
		
		return "Productos";
	}
	
	@GetMapping("/producto/{id}")
	public String detalleProducto(@PathVariable("id") long id, Model model){
		
		Product p = productService.obtenerUnProducto(id);
		
		if (p != null) {
			model.addAttribute("producto",p);
			return "DetalleProducto";
		} else {
			//tratamiento del error
			return "Error";
		}
	}
	

}
