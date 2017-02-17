package com.salesianostriana.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection instance = null;
	
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		if (instance == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:HR/1@localhost:1521/XE";
			instance = DriverManager.getConnection(url);			
		}
		return instance;
	}
	
	public static void close() throws SQLException {
		instance.close();
		instance = null;
	}
	
	

}
