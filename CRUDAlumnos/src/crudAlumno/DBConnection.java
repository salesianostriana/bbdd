package crudAlumno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

		private static Connection instance = null;
		

		public static Connection getConnection() 
				throws ClassNotFoundException, SQLException {
			if (instance == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:MRAMALLO/1@localhost:1521/XE";
				instance = DriverManager.getConnection(url);			
			}
			return instance;
		}
		
		public static Statement getStatement() throws ClassNotFoundException, SQLException {
			return getConnection().createStatement();
		}
			
		public static ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException {
			return getStatement().executeQuery(sql);
		}
		
		public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
			return getConnection().prepareStatement(sql);
		}
		
		public static void close() throws SQLException {
			instance.close();
			instance = null;
		}
		
	
	
}
