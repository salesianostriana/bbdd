package crudAlumno;

import java.sql.SQLException;
import java.util.List;

public class Main {

	static CRUDAlumno crudAlum;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Abrimos la conexión con la BBDD
		DBConnection.getConnection();
		// Instanciamos el CRUD de Alumnos para realizar las operaciones con él
		crudAlum = new CRUDAlumnoImpl();

		int opcion;

		do {
			menu();
			opcion = Leer.datoInt();

			switch (opcion) {
			case 0:
				break;
			case 1:
				altaAlumno();
				break;

			case 2:
				bajaAlumno();
				break;

			case 3:
				editarAlumno();
				break;
				
			case 4:
				editarHorasFaltas();
				break;

			case 5:
				listarAlumnos();
				break;

			case 6:
				listaUnAlumno();
				break;

			case 7:
				listaAlumnosMas15PorCiento();

			default:
				System.out.println("ERROR, opción incorrecta, vuelva a introducir una nueva");

			}

		} while (opcion != 0);

		DBConnection.close();

	}

	public static void menu() {
		System.out.println("************** MENU ***************");
		System.out.println("0. Salir");
		System.out.println("1. Insertar un alumno");
		System.out.println("2. Eliminar un alumno");
		System.out.println("3. Actualizar los datos de un alumno");
		System.out.println("4. Actualizar el nÃºmero de horas de faltas de un alumno");
		System.out.println("5. Listar todos los alumnos");
		System.out.println("6. Listar los datos de un alumno");
		System.out.println(
				"7. Listar los alumnos que hayan superado el 15% de faltas en el 2Âº trimestre (es decir, que tengan mÃ¡s de 29 horas de faltas).");
		System.out.println("*************************************");
		System.out.println("Introduzca una opciï¿½n: ");
		System.out.println();
	}

	public static void altaAlumno() throws ClassNotFoundException, SQLException {
		String nombre, apellidos, correoElectronico, fechaNacimiento;
		int idUsuario, horasFaltas;
		System.out.println("Insertar un alumno");
		System.out.println("=======================");
		System.out.println("Introduzca el ID del alumno");
		idUsuario = Leer.datoInt();
		System.out.println("Introduzca el nombre del alumno");
		nombre = Leer.dato();
		System.out.println("Introduzca los apellidos del alumno");
		apellidos = Leer.dato();
		System.out.println("Introduzca la fecha de nacimiento del alumno");
		fechaNacimiento = Leer.dato();
		System.out.println("Introduzca el correo electronico del alumno");
		correoElectronico = Leer.dato();
		System.out.println("Introduzca las horas de falta del alumno");
		horasFaltas = Leer.datoInt();

		crudAlum.insert(new Alumno(idUsuario, nombre, apellidos, fechaNacimiento, correoElectronico, horasFaltas));
	}

	public static void bajaAlumno() throws ClassNotFoundException, SQLException {
		int idUsuario;
		System.out.println("Eliminar un alumno");
		System.out.println("==========================");
		System.out.println("Diga el id del alumno que quiera eliminar");
		idUsuario = Leer.datoInt();
		crudAlum.delete(new Alumno(idUsuario, null, null, null, null, 0));
	}

	public static void editarAlumno() throws ClassNotFoundException, SQLException {
		String nombre, apellidos, correoElectronico, fechaNacimiento;
		int idUsuario, horasFaltas;
		System.out.println("Actualizar los datos de un alumno");
		System.out.println("=================================");
		System.out.println("Diga el id del alumno que quiera cambiar");
		System.out.println("Introduzca el ID del alumno");
		idUsuario = Leer.datoInt();
		System.out.println("Introduzca el nombre del alumno");
		nombre = Leer.dato();
		System.out.println("Introduzca los apellidos del alumno");
		apellidos = Leer.dato();
		System.out.println("Introduzca la fecha de nacimiento del alumno");
		fechaNacimiento = Leer.dato();
		System.out.println("Introduzca el correo electronico del alumno");
		correoElectronico = Leer.dato();
		System.out.println("Introduzca las horas de falta del alumno");
		horasFaltas = Leer.datoInt();

		crudAlum.edit(new Alumno(idUsuario, nombre, apellidos, fechaNacimiento, correoElectronico, horasFaltas));

	}
	
	public static void editarHorasFaltas() throws ClassNotFoundException, SQLException {
		int idUsuario, horasFaltas;
		System.out.println("Actualizar las horas de faltas un alumno");
		System.out.println("=================================");
		System.out.println("Diga el id del alumno que quiera cambiar");
		System.out.println("Introduzca el ID del alumno");
		idUsuario = Leer.datoInt();
		
		Alumno a = crudAlum.findOne(idUsuario);
		
		if (a == null) {
			System.out.println("El alumno a editar no existe");
		} else {
			System.out.println("Introduzca las horas de falta del alumno");
			horasFaltas = Leer.datoInt();
			a.setHoras_faltas(horasFaltas);
			crudAlum.edit(a);
		}

	}

	public static void listarAlumnos() throws ClassNotFoundException, SQLException {
		List<Alumno> lista = crudAlum.findAll();

		if (lista != null) {
			for (Alumno a : lista) {
				System.out.println(a);
			}
		} else {
			System.out.println("No hay alumnos registrados");
		}
	}

	public static void listaAlumnosMas15PorCiento() throws ClassNotFoundException, SQLException {
		//List<Alumno> lista = ((CRUDAlumnoImpl)crudAlum).obtenerAlumnos15Porciento();
		
		CRUDAlumnoImpl crudAlumnoImpl = (CRUDAlumnoImpl) crudAlum;
		List<Alumno> lista = crudAlumnoImpl.obtenerAlumnos15Porciento();

		if (lista != null) {
			for (Alumno a : lista) {
				System.out.println(a);
			}
		} else {
			System.out.println("No hay alumnos registrados");
		}
	}

	public static void listaUnAlumno() throws ClassNotFoundException, SQLException {

		System.out.println("Introduzca el ID del alumno");
		int idUsuario = Leer.datoInt();

		Alumno a = crudAlum.findOne(idUsuario);

		if (a != null)
			System.out.println(a);
		else
			System.out.println("No existe un alumno con ese valor para el ID");

	}
}
