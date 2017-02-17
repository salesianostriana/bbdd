package com.salesianostriana.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionEmpleados {

	public static void imprimirEmpleados() throws ClassNotFoundException, SQLException {
		//ANTES (1.0)
		//Connection con = DBConnection.getConnection();
		//Statement stm = con.createStatement();

		
		//OTRA FORMA (2.0)
		//Statement stm = DBConnection.getStatement();
		
		//LA DEFINITIVA (3.0)			
		//ResultSet rs = stm.executeQuery("SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_NAME "
		//		+ "FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)");
		
		//Paso 1: LANZAR LA CONSULTA
		String sql = "SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_NAME "
						+ "FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)";
		ResultSet rs = DBConnection.getResultSet(sql);

		//PASO 2: PROCESAR LOS RESULTADOS
		while (rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(firstName + " " + lastName + " (" + departmentName + ")");
		}

		//PASO 3: CERRAR LA "CONEXIÓN" (Cerramos realmente el RESULTSET,
		//la conexión sigue abierta en la clase DBConnection).
		rs.close();
		//stm.close();
		//con.close();
	}
	
	public static void imprimirDepartamentos() throws ClassNotFoundException, SQLException {
//		Connection con = DBConnection.getConnection();
//		Statement stm = con.createStatement();
//		ResultSet rs = stm.executeQuery("SELECT DEPARTMENT_NAME "
//				+ "FROM DEPARTMENTS");
		String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENTS";
		ResultSet rs = DBConnection.getResultSet(sql);

		while (rs.next()) {
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(departmentName);
		}

		rs.close();
		//stm.close();
		//con.close();
	}
	
	public static void imprimirLosElegidos() throws ClassNotFoundException, SQLException {
		String sql = "SELECT FIRST_NAME, LAST_NAME, SALARY "
			+" FROM (SELECT FIRST_NAME, LAST_NAME, SALARY "
				+ "  FROM EMPLOYEES ORDER BY SALARY DESC)"
			+" WHERE ROWNUM <= 5";
		ResultSet rs = DBConnection.getResultSet(sql);

		System.out.println("LOS 5 ELEGIDOS QUE MÁS COBRAN SON");
		System.out.println("=================================");
		while(rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			double salary = rs.getDouble("SALARY");
			System.out.println(firstName + " " + lastName + " (" + salary + ")");	
		}
	}

}
