package com.salesianostriana.bd;

import java.sql.SQLException;
import java.util.List;

public class JdbcQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Inicializamos la conexión, para aliviar el trabajo
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
				//GestionEmpleados.imprimirEmpleados();
				List<Empleado> lista = GestionEmpleados.obtenerEmpleados();
				for(Empleado e : lista) {
					System.out.println(e);
				}
				break;
			case 2:
				List<Empleado> lista2 = GestionEmpleados.obtenerEmpleados();
				System.out.println("<html>");	
				System.out.println("<head></head>");	
				System.out.println("<body>");
				System.out.println("<table>");
				System.out.println("<thead>");
				System.out.println("<tr>");
				System.out.println("<th>Nombre</th>");
				System.out.println("<th>Apellidos</th>");
				System.out.println("</tr>");
				System.out.println("</thead>");
				System.out.println("<tbody>");
				for(Empleado e : lista2) {
					System.out.println("<tr>");
					System.out.println("<td>" + e.getFirst_name() + "</td>");
					System.out.println("<td>" + e.getLast_name() + "</td>");					
					System.out.println("</tr>");				
				}
				System.out.println("</tbody>");
				System.out.println("</body>");
				System.out.println("</html>");
				
				break;
				
			case 3:
				GestionEmpleados.imprimirDepartamentos();
				break;
			case 4:
				GestionEmpleados.imprimirLosElegidos();
				break;
			case 5: 
				System.out.println("Introduzca el valor menor del intervalo");
				double desde = Leer.datoDouble();
				System.out.println("Introduzca el valor mayor del intervalo");
				double hasta = Leer.datoDouble();
				List<Empleado> lista3 = GestionEmpleados
						.obtenerEmpleadosConSalarioEntre(desde, hasta);
				for(Empleado e : lista3) {
					System.out.println(e);
				}
				break;
			case 6:
				System.out.println("Introduzca el email en cuestión");
				String email = Leer.dato();
				List<Empleado> lista4 = GestionEmpleados
						.obtenerEmpleadosPorEmail(email);
				for(Empleado e : lista4) {
					System.out.println(e);
				}
				break;
			case 7:
				System.out.println("Introduzca el nombre");
				String nombre = Leer.dato();
				System.out.println("Introduzca el apellido");
				String apellido = Leer.dato();
				List<Empleado> lista5 = GestionEmpleados
						.obtenerEmpleadosPorNombreOApellido(nombre, apellido);
				for(Empleado e : lista5) {
					System.out.println(e);
				}
				break;
			default:
				System.out.println("¿Pero qué dices?");
				break;

			}
		} while (opcion != 0);
		
		//Finalizamos la conexión, ya que no lo vamos
		//a usar más.
		DBConnection.close();

	}

	public static void menu() {
		System.out.println("MENUUUUUU");
		System.out.println("0. Salir");
		System.out.println("1. Listar empleados");
		System.out.println("2. Listar empleados en HTML");
		System.out.println("3. Listar departamentos");
		System.out.println("4. Listar los 5 elegidos que más cobran");
		System.out.println("5. Listar los empleados que cobran un salario en un intervalo");
		System.out.println("6. Listar los empleados que coinciden en un email");
		System.out.println("7. Listar los empleados por NOMBRE o por APELLIDO");
		System.out.println("Introduzca una opción: ");
	}

}
