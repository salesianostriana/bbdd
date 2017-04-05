package com.salesianostriana.dam.nuevospringcrudalumnos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudAlumnoImpl implements CrudAlumno {
	
	@Autowired
	DBConnection dbConnection;

	public List<Alumno> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Alumno findOne(int codAlum) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Alumno a) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public void edit(Alumno a) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Alumno a) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
