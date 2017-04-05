package com.salesianostriana.dam.nuevospringcrudalumnos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorAlumno {
	
	@Autowired
	CrudAlumno crudAlumno;
	
	
	public void listarAlumnos() {
		System.out.println("Listando alumnos");
	}


}
