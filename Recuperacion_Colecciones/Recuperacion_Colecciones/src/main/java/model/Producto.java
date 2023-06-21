package main.java.model;

import java.time.LocalDate;

public class Producto {

	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private String nombre;
	private int id;
	private String descripcion;
	private Double precioUnitario;
	
	public Producto(String descripcion){
		super();
		this.descripcion=descripcion;
	}
	
	public Producto(String nombre, String descripcion,Double precioUnitario) {
		super();
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precioUnitario=precioUnitario;
		this.fechaAlta=LocalDate.now();
	}
	
	public boolean isActive() {
		boolean estaActivo=false;
		
		if((LocalDate.now().isAfter(fechaAlta) || LocalDate.now().equals(fechaAlta)) && (LocalDate.now().isBefore(fechaBaja))){
			estaActivo=true;
		}
		
		return estaActivo;
	}

	public int getId() {
		return id;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Producto [fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nombre=" + nombre + ", id=" + id
				+ ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + "]";
	}
	
	

}
