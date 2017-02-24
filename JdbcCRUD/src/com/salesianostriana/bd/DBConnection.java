package com.salesianostriana.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	//Instancia �nica de Connection
	private static Connection instance = null;
	
	//M�todo para obtener el objeto Connection en cualquier 
	//parte de la aplicaci�n
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		if (instance == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:PRODUCTOS/1@localhost:1521/XE";
			instance = DriverManager.getConnection(url);			
		}
		return instance;
	}
	
	//M�todo para inicializar un Statement - Versi�n 2.0
	public static Statement getStatement() throws ClassNotFoundException, SQLException {
		return getConnection().createStatement();
	}
	
	//M�todo para inicializar un Statement y lanzar la consulta - Versi�n 3.0	
	public static ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException {
		return getStatement().executeQuery(sql);
	}
	
	//M�todo para inicializar un PrepraredStatment
	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		return getConnection().prepareStatement(sql);
	}
	
	public static void close() throws SQLException {
		instance.close();
		instance = null;
	}
	
	

}
