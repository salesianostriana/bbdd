package crudAlumno;

import java.sql.SQLException;
import java.util.List;


public interface CRUDAlumno {

	List<Alumno> findAll() throws ClassNotFoundException, SQLException;

	Alumno findOne(int codAlum) throws ClassNotFoundException, SQLException;

	void insert(Alumno a) throws ClassNotFoundException, SQLException;

	void edit(Alumno a) throws ClassNotFoundException, SQLException;

	void delete(Alumno a) throws ClassNotFoundException, SQLException;
	
	
}
