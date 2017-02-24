package com.salesianostriana.bd.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.salesianostriana.bd.DBConnection;
import com.salesianostriana.bd.modelo.Producto;

public class CrudProductoImpl implements CrudProducto {

	@Override
	public List<Producto> findAll() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM PRODUCTOS";
		ResultSet rs = DBConnection.getResultSet(sql);
		List<Producto> result = new ArrayList<Producto>();
		while(rs.next()) {
			result.add(
					new Producto(
							rs.getInt("codProd"), 
							rs.getString("nombre"),
							rs.getFloat("precioUnitario")));
		}
		
		rs.close();
		
		return result;
	}

	@Override
	public Producto findOne(int codProd) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM PRODUCTOS WHERE CODPROD = ? ";
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setInt(1, codProd);
		ResultSet rs = ps.executeQuery();
		
		Producto result = null;
		
		while(rs.next()) {
			result = new Producto(
					rs.getInt("codProd"), 
					rs.getString("nombre"),
					rs.getFloat("precioUnitario"));
		}

		return result;
	}

	@Override
	public void insert(Producto p) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO PRODUCTOS (CODPROD, NOMBRE, PRECIOUNITARIO) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setInt(1, p.getCodProd());
		ps.setString(2,  p.getNombre());
		ps.setFloat(3,  p.getPrecioUnitario());
		
		ps.executeUpdate();
		
		ps.close();
		


	}
	

	@Override
	public void edit(Producto p) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE PRODUCTOS SET NOMBRE = ?, PRECIOUNITARIO = ? "
				+ "WHERE CODPROD = ?";
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setString(1,  p.getNombre());
		ps.setFloat(2,  p.getPrecioUnitario());
		ps.setInt(3, p.getCodProd());
		
		ps.executeUpdate();
		
		ps.close();


	}

	@Override
	public void delete(Producto p) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM PRODUCTOS "
				+ "WHERE CODPROD = ?";
		
		PreparedStatement ps = DBConnection.getPreparedStatement(sql);
		// Paso 1.1: LE ASIGNAMOS LOS VALORES
		ps.setInt(1, p.getCodProd());
		
		ps.executeUpdate();
		
		ps.close();

	}

}
