package com.salesianostriana.bd;

import java.sql.SQLException;

public class JdbcSingleton {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		DBConnection.getConnection();
		
		int opcion;
		do {
			menu();
			opcion = Leer.datoInt();

			switch (opcion) {
			case 0: // Salir
				break;
			case 1:
				GestionEmpleados.imprimirEmpleados();
				break;
			case 2:
				GestionEmpleados.imprimirDepartamentos();
				break;
			default:
				System.out.println("¿Pero qué dices?");
				break;

			}
		} while (opcion != 0);
		
		DBConnection.close();

	}

	public static void menu() {
		System.out.println("MENUUUUUU");
		System.out.println("0. Salir");
		System.out.println("1. Listar empleados");
		System.out.println("2. Listar departamentos");
		System.out.println("Introduzca una opción: ");
	}

}
