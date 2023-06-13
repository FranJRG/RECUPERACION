package restaurante.model;

import java.time.LocalDate;

public abstract class Producto {
	
	private static final double IVA_GENERAL=0.07;
	protected LocalDate fechaAltaMenu;
	protected LocalDate fechaBajaMenu;
	protected String nombre;
	protected String descripcion;
	protected Alergeno alergeno;
	protected double precioBase;
	protected String codigoProducto;
	
	
	public Producto(String nombre, String descripcion, Alergeno alergeno, double precioBase) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alergeno = alergeno;
		this.precioBase = precioBase;
	}


	public LocalDate getFechaBajaMenu() {
		return fechaBajaMenu;
	}

	
	public abstract double getPrecioProducto();
	
	public void setFechaBajaMenu(LocalDate fechaBajaMenu) {
		this.fechaBajaMenu = fechaBajaMenu;
	}

	public abstract boolean estaCaducado();
	
	public Alergeno getAlergeno() {
		return alergeno;
	}


	public String getCodigoProducto() {
		return codigoProducto;
	}


	@Override
	public String toString() {
		return "Producto " + this.getClass().getSimpleName() + 
					" precio " + this.getPrecioProducto() + " ingredientes " + this.descripcion;
	}
	
	
	
	
}
