package crudAlumno;

import java.sql.Date;

public class Alumno {

	private int id;
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private String correo_electronico;
	private int horas_faltas;

	public Alumno(int id, String nombre, String apellidos, String fecha_nacimiento, String correo_electronico,
			int horas_faltas) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo_electronico = correo_electronico;
		this.horas_faltas = horas_faltas;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public int getHoras_faltas() {
		return horas_faltas;
	}

	public void setHoras_faltas(int horas_faltas) {
		this.horas_faltas = horas_faltas;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento="
				+ fecha_nacimiento + ", correo_electronico=" + correo_electronico + ", horas_faltas=" + horas_faltas
				+ "]";
	}

}
