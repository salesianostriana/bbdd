package com.salesianostriana.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	//Instancia única de Connection
	private static Connection instance = null;
	
	//Método para obtener el objeto Connection en cualquier 
	//parte de la aplicación
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		if (instance == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:PRODUCTOS/1@localhost:1521/XE";
			instance = DriverManager.getConnection(url);			
		}
		return instance;
	}
	
	//Método para inicializar un Statement - Versión 2.0
	public static Statement getStatement() throws ClassNotFoundException, SQLException {
		return getConnection().createStatement();
	}
	
	//Método para inicializar un Statement y lanzar la consulta - Versión 3.0	
	public static ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException {
		return getStatement().executeQuery(sql);
	}
	
	//Método para inicializar un PrepraredStatment
	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		return getConnection().prepareStatement(sql);
	}
	
	public static void close() throws SQLException {
		instance.close();
		instance = null;
	}
	
	

}
