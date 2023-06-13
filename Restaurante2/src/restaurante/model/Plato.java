package restaurante.model;

import java.time.LocalDate;

public class Plato extends Producto{

	private static final double IVA_GENERAL = 0.07;
	protected LocalDate fechaConsumoPreferente;
	
	
	public Plato(String nombre, String descripcion, Alergeno alergeno, double precioBase) {
		super(nombre, descripcion, alergeno, precioBase);
		this.fechaConsumoPreferente=LocalDate.now();
	}


	@Override
	public double getPrecioProducto() {
		
		return this.precioBase*IVA_GENERAL;
	}

	@Override
	public boolean estaCaducado() {
		boolean estaCaducado=false;

		if(fechaConsumoPreferente.equals(LocalDate.now()) || this.fechaConsumoPreferente.isAfter(fechaConsumoPreferente.plusDays(15))) {
			estaCaducado=true;
		}
		
		return estaCaducado;
	}


	public LocalDate getFechaConsumoPreferente() {
		return fechaConsumoPreferente;
	}


	public void setFechaConsumoPreferente(LocalDate fechaConsumoPreferente) {
		this.fechaConsumoPreferente = fechaConsumoPreferente;
	}


	@Override
	public String toString() {
		return "Plato: " + this.nombre + " Precio: " + this.getPrecioProducto() + 
				" Presenta alérgenos " + this.getAlergeno() + " Fecha de consumo preferente " + 
					this.getFechaConsumoPreferente() + " Ingredientes " + this.descripcion;
	}
	
	
	
}
