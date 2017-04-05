package com.salesianostriana.dam.nuevospringcrudalumnos;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class App {
	
	@Autowired
	ControladorAlumno controladorAlumno;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/salesianostriana/dam/xml/beans.xml");

		App app = (App) context.getBean("app");

		app.init();
		
		

	}

	public App() {
	}

	public void init() {

		// Pintar el menú
		// Usar los controladores para cada opción
		Scanner sc = new Scanner(System.in);

		int opcion;

		do {
			menu();
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 0:
				break;
			case 1:
				// Opción 1
				controladorAlumno.listarAlumnos();
				break;

			case 2:
				// Opción 2
				//controladorAlumno......
				break;

			//Resto de opciones
				
			default:
				System.out.println("ERROR, opción incorrecta, vuelva a introducir una nueva");

			}

		} while (opcion != 0);
		
		sc.close();
	}

	

	public static void menu() {
		System.out.println("************** MENU ***************");
		System.out.println("0. Salir");
		System.out.println("1. Listar todos los alumnos");
		//Resto de opciones...
		System.out.println("*************************************");
		System.out.println("Introduzca una opción: ");
		System.out.println();
	}

}
