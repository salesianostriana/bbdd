package com.salesianostriana.bd;

import java.sql.SQLException;
import java.util.List;

import com.salesianostriana.bd.crud.CrudProducto;
import com.salesianostriana.bd.crud.CrudProductoImpl;
import com.salesianostriana.bd.modelo.Producto;

public class JdbcCRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Inicializamos la conexión, para aliviar el trabajo
		//de la primera consulta
		DBConnection.getConnection();
		
		CrudProducto crudProducto = new CrudProductoImpl();
		
		int opcion;
		do {
			menu();
			opcion = Leer.datoInt();

			switch (opcion) {
			case 0: // Salir
				break;
			case 1: System.out.println("Creación de un producto");
					System.out.println("=======================");
					System.out.println("Introduzca el ID del producto");
					int id = Leer.datoInt();
					System.out.println("Introduzca el nombre del producto");
					String nombre = Leer.dato();
					System.out.println("Introduzca el precio unitario del producto");
					float precioUnitario = Leer.datoFloat();
					crudProducto.insert(new Producto(id, nombre, precioUnitario));
				break;
			case 2:
				System.out.println("Actualización de un producto");
				System.out.println("=======================");
				System.out.println("Introduzca el ID del producto");
				id = Leer.datoInt();
				System.out.println("Introduzca el nombre del producto");
				nombre = Leer.dato();
				System.out.println("Introduzca el precio unitario del producto");
				precioUnitario = Leer.datoFloat();
				crudProducto.edit(new Producto(id, nombre, precioUnitario));
				break;
				
			case 3: System.out.println("Actualización de un producto");					System.out.println("=======================");
					System.out.println("Introduzca el ID del producto");
					id = Leer.datoInt();
					crudProducto.delete(new Producto(id, null, 0.0F));
				break;
			case 4:
				
				break;
			case 5: System.out.println("Listando todos los productos");
					System.out.println("============================");
					List<Producto> list = crudProducto.findAll();
					if (list.size() > 0)
						for(Producto p : list) 
							System.out.println(p);
					else
						System.out.println("No hay productos que listar \n\n");
						
				break;
			case 6: 
				System.out.println("Actualización de un producto");					System.out.println("=======================");
				System.out.println("Introduzca el ID del producto");
				id = Leer.datoInt();
				Producto producto = crudProducto.findOne(id);
				if (producto != null)
					System.out.println(producto);
				else
					System.out.println("No existe ningún producto con ese ID");
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
		System.out.println("MENU");
		System.out.println("0. Salir");
		System.out.println("1. Crear un producto");
		System.out.println("2. Actualizar un producto");
		System.out.println("3. Borrar un producto");
		System.out.println("4. Borrar todos los productos");
		System.out.println("5. Listar todos los productos");
		System.out.println("6. Buscar un producto por su ID");
		System.out.println("Introduzca una opción: ");
	}

}
