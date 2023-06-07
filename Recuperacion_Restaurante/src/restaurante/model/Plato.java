package restaurante.model;

import java.time.LocalDate;

public class Plato extends Producto{

	protected LocalDate fechaConsumoPreferente;

	public Plato(String nombre, String descripcion, Alergeno alergeno, double precioBase) {
		super(nombre,descripcion,alergeno,precioBase);
		this.fechaConsumoPreferente=LocalDate.now();
	}

	@Override
	public double getPrecioProducto() {
		return this.precioBase*IVA_GENERAL;
	}
	
	public LocalDate getFechaConsumoPreferente() {
		return this.fechaConsumoPreferente;
	}
	
	public void setFechaConsumoPreferente(LocalDate fechaConsumoPreferente) {
		this.fechaConsumoPreferente=fechaConsumoPreferente;
	}
	
	@Override
	public boolean estaCaducado() {
		boolean cad=false;
		
		if(this.fechaConsumoPreferente.equals(LocalDate.now()) || this.fechaConsumoPreferente.isAfter(fechaConsumoPreferente.plusDays(15))) {
			cad=true;
		}
		
		return cad;
	}

	@Override
	public String toString() {
		return "Plato " + nombre + " Precio " + getPrecioProducto() + " Presenta alérgenos " + alergeno + " Fecha de consumo preferente " + getFechaConsumoPreferente();
	}
	
	
	
}
