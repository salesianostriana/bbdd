package com.salesianostriana.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:HR/1@localhost:1521/XE";
		Connection con = DriverManager.getConnection(url);
		
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_NAME "
				+ "FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)");
		
		while(rs.next()) {
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			System.out.println(firstName + " " + lastName + " (" + departmentName+ ")");		
		}
		
		rs.close();
		stm.close();
		con.close();
				
		
	}
	
	
}
