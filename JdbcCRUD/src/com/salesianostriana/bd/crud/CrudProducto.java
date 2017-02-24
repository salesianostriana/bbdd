package com.salesianostriana.bd.crud;

import java.sql.SQLException;
import java.util.List;

import com.salesianostriana.bd.modelo.Producto;

public interface CrudProducto {

	List<Producto> findAll() throws ClassNotFoundException, SQLException;

	Producto findOne(int codProd) throws ClassNotFoundException, SQLException;

	void insert(Producto p) throws ClassNotFoundException, SQLException;

	void edit(Producto p) throws ClassNotFoundException, SQLException;

	void delete(Producto p) throws ClassNotFoundException, SQLException;

}
