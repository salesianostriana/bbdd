package crudAlumno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CRUDAlumnoImpl implements CRUDAlumno {

	@Override
	public List<Alumno> findAll() throws ClassNotFoundException, SQLException {
		String sql = "SELECT ID_ALUMNO, NOMBRE, APELLIDOS,"
				+ " TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY') AS FEC_NAC, "
				+ " CORREO_ELECTRONICO, HORAS_FALTAS "
				+ " FROM ALUM";
		
		List<Alumno> result = null;
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if (result == null)
				result = new ArrayList<Alumno>();
			
			result.add(new Alumno(rs.getInt("ID_ALUMNO"),
					rs.getString("NOMBRE"),
					rs.getString("APELLIDOS"),
					rs.getString("FEC_NAC"),
					rs.getString("CORREO_ELECTRONICO"),
					rs.getInt("HORAS_FALTAS")));
		}
		
		rs.close();
		ps.close();
		
		return result;
	}
	
	public List<Alumno> obtenerAlumnos15Porciento() throws ClassNotFoundException, SQLException {
		String sql = "SELECT ID_ALUMNO, NOMBRE, APELLIDOS,"
				+ " TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY') AS FEC_NAC, "
				+ " CORREO_ELECTRONICO, HORAS_FALTAS "
				+ " FROM ALUM "
				+ " WHERE HORAS_FALTAS >= 29";
		
		List<Alumno> result = null;
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if (result == null)
				result = new ArrayList<Alumno>();
			
			result.add(new Alumno(rs.getInt("ID_ALUMNO"),
					rs.getString("NOMBRE"),
					rs.getString("APELLIDOS"),
					rs.getString("FEC_NAC"),
					rs.getString("CORREO_ELECTRONICO"),
					rs.getInt("HORAS_FALTAS")));
		}
		
		rs.close();
		ps.close();
		
		return result;
	}

	@Override
	public Alumno findOne(int codAlum) throws ClassNotFoundException, SQLException {
		
		//1º Definir la consulta SQL
		String sql = "SELECT ID_ALUMNO, NOMBRE, APELLIDOS,"
				+ " TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY') AS FEC_NAC, "
				+ " CORREO_ELECTRONICO, HORAS_FALTAS "
				+ " FROM ALUM "
				+ " WHERE ID_ALUMNO = ?";
		
		//2º Obtenemos el PreparedStatement para esa consulta 
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		
		//3º Le asignamos valores
		ps.setInt(1, codAlum);
		
		//4º Ejecutamos la consulta
		ResultSet rs = ps.executeQuery();
		
		//5º Procesamos y devolvemos los datos
		
		//Si hay datos
		if (rs.next()) {
			//Hay resultado
			return new Alumno(rs.getInt("ID_ALUMNO"),
					rs.getString("NOMBRE"),
					rs.getString("APELLIDOS"),
					rs.getString("FEC_NAC"),
					rs.getString("CORREO_ELECTRONICO"),
					rs.getInt("HORAS_FALTAS"));
		} 
		
		return null;
	}

	@Override
	public void insert(Alumno a) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO ALUM (ID_ALUMNO, NOMBRE, APELLIDOS, FECHA_NACIMIENTO, CORREO_ELECTRONICO, HORAS_FALTAS) "
				+ "VALUES (?, ?, ?, TO_DATE(?,'DD/MM/YYYY'), ?, ?)";
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setInt(1, a.getId());
		ps.setString(2,  a.getNombre());
		ps.setString(3,  a.getApellidos());
		ps.setString(4, a.getFecha_nacimiento());
		ps.setString(5, a.getCorreo_electronico());
		ps.setInt(6, a.getHoras_faltas());
		
		ps.executeUpdate();
		
		ps.close();
		
		
	}

	@Override
	public void edit(Alumno a) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE ALUM SET NOMBRE = ?, APELLIDOS = ?, FECHA_NACIMIENTO = ?, CORREO_ELECTRONICO = ?, HORAS_FALTAS = ? "
				+ "WHERE ID_ALUMNO = ?";
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);

		ps.setString(1,  a.getNombre());
		ps.setString(2,  a.getApellidos());
		ps.setString(3, a.getFecha_nacimiento());
		ps.setString(4, a.getCorreo_electronico());
		ps.setInt(5, a.getHoras_faltas());
		ps.setInt(6, a.getId());
		
		ps.executeUpdate();
		
		ps.close();
		
	}

	@Override
	public void delete(Alumno a) throws ClassNotFoundException, SQLException {
		
		String sql = "DELETE FROM ALUM "
				+ "WHERE ID = ?";
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		
		ps.setInt(1, a.getId());
		
		ps.executeUpdate();
		
		ps.close();
		
		
	}

}
