package com.salesianostriana.bd.modelo;

public class Producto {

	private int codProd;
	private String nombre;
	private float precioUnitario;

	public Producto(int codProd, String nombre, float precioUnitario) {
		super();
		this.codProd = codProd;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
	}

	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Producto [codProd=" + codProd + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + "]";
	}

}
