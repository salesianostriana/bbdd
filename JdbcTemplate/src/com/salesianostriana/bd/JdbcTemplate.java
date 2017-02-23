package com.salesianostriana.bd;

import java.sql.SQLException;

public class JdbcTemplate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Inicializamos la conexi�n, para aliviar el trabajo
		//de la primera consulta
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
			case 3:
				GestionEmpleados.imprimirLosElegidos();
				break;
			default:
				System.out.println("�Pero qu� dices?");
				break;

			}
		} while (opcion != 0);
		
		//Finalizamos la conexi�n, ya que no lo vamos
		//a usar m�s.
		DBConnection.close();

	}

	public static void menu() {
		System.out.println("MENUUUUUU");
		System.out.println("0. Salir");
		System.out.println("1. Listar empleados");
		System.out.println("2. Listar departamentos");
		System.out.println("3. Listar los 5 elegidos que m�s cobran");
		System.out.println("Introduzca una opci�n: ");
	}

}
