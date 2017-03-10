package crudAlumno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDAlumnoImpl2 implements CRUDAlumno{
	List<Alumno> data = new ArrayList<Alumno>();
	
	public List<Alumno> findAll() throws ClassNotFoundException {
		return data;
	}
	
	public List<Alumno> obtenerAlumnos15Porciento(List<Alumno> result) throws ClassNotFoundException {
		List<Alumno> morosos = new ArrayList<Alumno>();
		for(Alumno a: result) {
			if(a.getHoras_faltas() > 29) {
				morosos.add(a);
			}
		}
		return morosos;
	}

	public Alumno findOne(int codAlum) throws ClassNotFoundException {
		/*for(Alumno a: data) {
			if(codAlum == a.getId()) {
				return a;
			}
		}
		return null;*/
		int pos = getIndex(codAlum);
		if (pos != -1)
			return data.get(pos);
		
		return null;
	}

	public void insert(Alumno a) throws ClassNotFoundException {
		data.add(a);
	}

	public void edit(Alumno a) throws ClassNotFoundException {
		int pos = getIndex(a.getId());
		if (pos != -1) {
			//Alumno rescatado = data.get(pos);
			data.get(pos).setNombre(a.getNombre());
			data.get(pos).setApellidos(a.getApellidos());
			data.get(pos).setCorreo_electronico(a.getCorreo_electronico());
			data.get(pos).setFecha_nacimiento(a.getFecha_nacimiento());
			data.get(pos).setHoras_faltas(a.getHoras_faltas());
		}
	}

	public void delete(Alumno a) throws ClassNotFoundException {
		data.remove(a.getId());
	}
	
	private int getIndex(int codAlumno) {
		for(int i = 0; i < data.size(); i++) {
			if (codAlumno == data.get(i).getId()) {
				return i;
			}
		}
		
		return -1;
	}

	
}
