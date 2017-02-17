package com.salesianostriana.bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionEmpleados {

	public static void imprimirEmpleados() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		Statement stm = con.createStatement();

		ResultSet rs = stm.executeQuery("SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_NAME "
				+ "FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)");

		while (rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(firstName + " " + lastName + " (" + departmentName + ")");
		}

		rs.close();
		stm.close();
		//con.close();
	}
	
	public static void imprimirDepartamentos() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		Statement stm = con.createStatement();

		ResultSet rs = stm.executeQuery("SELECT DEPARTMENT_NAME "
				+ "FROM DEPARTMENTS");

		while (rs.next()) {
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(departmentName);
		}

		rs.close();
		stm.close();
		//con.close();
	}

}
