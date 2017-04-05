package com.salesianostriana.dam.nuevospringcrudalumnos;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {

	private  Connection instance = null;
	
	
	public  Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		if (instance == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:MRAMALLO/1@localhost:1521/XE";
			instance = DriverManager.getConnection(url);			
		}
		return instance;
	}
	
	public DBConnection() throws ClassNotFoundException, SQLException {
		this.getConnection();
	}
	
	public  Statement getStatement() throws ClassNotFoundException, SQLException {
		return getConnection().createStatement();
	}
		
	public  ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException {
		return getStatement().executeQuery(sql);
	}
	
	public  PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		return getConnection().prepareStatement(sql);
	}
	
	public  void close() throws SQLException {
		instance.close();
		instance = null;
	}
	

	
}
