package com.salesianostriana.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {

	public static void imprimirEmpleados() throws ClassNotFoundException, SQLException {
		// ANTES (1.0)
		// Connection con = DBConnection.getConnection();
		// Statement stm = con.createStatement();

		// OTRA FORMA (2.0)
		// Statement stm = DBConnection.getStatement();

		// LA DEFINITIVA (3.0)
		// ResultSet rs = stm.executeQuery("SELECT FIRST_NAME, LAST_NAME,
		// DEPARTMENT_NAME "
		// + "FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)");

		// Paso 1: LANZAR LA CONSULTA
		String sql = "SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_NAME "
				+ "FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)";
		ResultSet rs = DBConnection.getResultSet(sql);

		// PASO 2: PROCESAR LOS RESULTADOS
		while (rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(firstName + " " + lastName + " (" + departmentName + ")");
		}

		// PASO 3: CERRAR LA "CONEXIÓN" (Cerramos realmente el RESULTSET,
		// la conexión sigue abierta en la clase DBConnection).
		rs.close();
		// stm.close();
		// con.close();
	}

	public static List<Empleado> obtenerEmpleados() throws ClassNotFoundException, SQLException {

		// Lista de resultados a devolver
		List<Empleado> resultado = new ArrayList<Empleado>();
		// ArrayList<Empleado> resultado = new ArrayList<Empleado>();

		// Paso 1: LANZAR LA CONSULTA
		String sql = "SELECT * FROM EMPLOYEES";
		ResultSet rs = DBConnection.getResultSet(sql);

		// PASO 2: PROCESAR LOS RESULTADOS
		while (rs.next()) {
			/*
			 * String firstName = rs.getString("FIRST_NAME"); String lastName =
			 * rs.getString("LAST_NAME"); String departmentName =
			 * rs.getString("DEPARTMENT_NAME"); System.out.println(firstName +
			 * " " + lastName + " (" + departmentName + ")");
			 */
			resultado.add(new Empleado(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
					rs.getString("EMAIL"), rs.getString("PHONE_NUMBER"), rs.getDate("HIRE_DATE"),
					rs.getString("JOB_ID"), rs.getDouble("SALARY"), rs.getDouble("COMMISSION_PCT"),
					rs.getInt("MANAGER_ID"), rs.getInt("DEPARTMENT_ID")));
		}

		// PASO 3: CERRAR LA "CONEXIÓN" (Cerramos realmente el RESULTSET,
		// la conexión sigue abierta en la clase DBConnection).
		rs.close();

		// Devolvemos los resultados
		return resultado;

	}

	public static List<Empleado> obtenerEmpleadosConSalarioEntre(double desde, double hasta)
			throws ClassNotFoundException, SQLException {

		// Lista de resultados a devolver
		List<Empleado> resultado = new ArrayList<Empleado>();
		// ArrayList<Empleado> resultado = new ArrayList<Empleado>();

		// Paso 1: LANZAR LA CONSULTA
		String sql = "SELECT * FROM EMPLOYEES " + " WHERE SALARY BETWEEN " + Double.toString(desde) + " AND "
				+ Double.toString(hasta);
		ResultSet rs = DBConnection.getResultSet(sql);

		// PASO 2: PROCESAR LOS RESULTADOS
		while (rs.next()) {
			/*
			 * String firstName = rs.getString("FIRST_NAME"); String lastName =
			 * rs.getString("LAST_NAME"); String departmentName =
			 * rs.getString("DEPARTMENT_NAME"); System.out.println(firstName +
			 * " " + lastName + " (" + departmentName + ")");
			 */
			resultado.add(new Empleado(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
					rs.getString("EMAIL"), rs.getString("PHONE_NUMBER"), rs.getDate("HIRE_DATE"),
					rs.getString("JOB_ID"), rs.getDouble("SALARY"), rs.getDouble("COMMISSION_PCT"),
					rs.getInt("MANAGER_ID"), rs.getInt("DEPARTMENT_ID")));
		}

		// PASO 3: CERRAR LA "CONEXIÓN" (Cerramos realmente el RESULTSET,
		// la conexión sigue abierta en la clase DBConnection).
		rs.close();

		// Devolvemos los resultados
		return resultado;

	}

	public static List<Empleado> obtenerEmpleadosPorEmail(String email) throws ClassNotFoundException, SQLException {

		// Lista de resultados a devolver
		List<Empleado> resultado = new ArrayList<Empleado>();
		// ArrayList<Empleado> resultado = new ArrayList<Empleado>();

		// Paso 1: LANZAR LA CONSULTA
		String sql = "SELECT * FROM EMPLOYEES WHERE EMAIL = ? ";
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		//ResultSet rs = DBConnection.getResultSet(sql);

		// PASO 2: PROCESAR LOS RESULTADOS
		while (rs.next()) {
			/*
			 * String firstName = rs.getString("FIRST_NAME"); String lastName =
			 * rs.getString("LAST_NAME"); String departmentName =
			 * rs.getString("DEPARTMENT_NAME"); System.out.println(firstName +
			 * " " + lastName + " (" + departmentName + ")");
			 */
			resultado.add(new Empleado(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
					rs.getString("EMAIL"), rs.getString("PHONE_NUMBER"), rs.getDate("HIRE_DATE"),
					rs.getString("JOB_ID"), rs.getDouble("SALARY"), rs.getDouble("COMMISSION_PCT"),
					rs.getInt("MANAGER_ID"), rs.getInt("DEPARTMENT_ID")));
		}

		// PASO 3: CERRAR LA "CONEXIÓN" (Cerramos realmente el RESULTSET,
		// la conexión sigue abierta en la clase DBConnection).
		rs.close();

		// Devolvemos los resultados
		return resultado;

	}

	public static List<Empleado> obtenerEmpleadosPorNombreOApellido(String nombre, String apellido) throws ClassNotFoundException, SQLException {

		// Lista de resultados a devolver
		List<Empleado> resultado = new ArrayList<Empleado>();
		// ArrayList<Empleado> resultado = new ArrayList<Empleado>();

		// Paso 1: LANZAR LA CONSULTA
		String sql = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE ? "
				+ "OR LAST_NAME LIKE ?";
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ResultSet rs = ps.executeQuery();
		//ResultSet rs = DBConnection.getResultSet(sql);

		// PASO 2: PROCESAR LOS RESULTADOS
		while (rs.next()) {
			/*
			 * String firstName = rs.getString("FIRST_NAME"); String lastName =
			 * rs.getString("LAST_NAME"); String departmentName =
			 * rs.getString("DEPARTMENT_NAME"); System.out.println(firstName +
			 * " " + lastName + " (" + departmentName + ")");
			 */
			resultado.add(new Empleado(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
					rs.getString("EMAIL"), rs.getString("PHONE_NUMBER"), rs.getDate("HIRE_DATE"),
					rs.getString("JOB_ID"), rs.getDouble("SALARY"), rs.getDouble("COMMISSION_PCT"),
					rs.getInt("MANAGER_ID"), rs.getInt("DEPARTMENT_ID")));
		}

		// PASO 3: CERRAR LA "CONEXIÓN" (Cerramos realmente el RESULTSET,
		// la conexión sigue abierta en la clase DBConnection).
		rs.close();

		// Devolvemos los resultados
		return resultado;

	}

	public static void imprimirDepartamentos() throws ClassNotFoundException, SQLException {
		// Connection con = DBConnection.getConnection();
		// Statement stm = con.createStatement();
		// ResultSet rs = stm.executeQuery("SELECT DEPARTMENT_NAME "
		// + "FROM DEPARTMENTS");
		String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENTS";
		ResultSet rs = DBConnection.getResultSet(sql);

		while (rs.next()) {
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(departmentName);
		}

		rs.close();
		// stm.close();
		// con.close();
	}

	public static void imprimirLosElegidos() throws ClassNotFoundException, SQLException {
		String sql = "SELECT FIRST_NAME, LAST_NAME, SALARY " + " FROM (SELECT FIRST_NAME, LAST_NAME, SALARY "
				+ "  FROM EMPLOYEES ORDER BY SALARY DESC)" + " WHERE ROWNUM <= 5";
		ResultSet rs = DBConnection.getResultSet(sql);

		System.out.println("LOS 5 ELEGIDOS QUE MÁS COBRAN SON");
		System.out.println("=================================");
		while (rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			double salary = rs.getDouble("SALARY");
			System.out.println(firstName + " " + lastName + " (" + salary + ")");
		}
	}

}
