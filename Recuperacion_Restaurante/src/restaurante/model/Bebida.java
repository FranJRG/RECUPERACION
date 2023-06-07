package restaurante.model;

import java.time.LocalDate;

public class Bebida extends Producto {
	
	private static final double IVA_BEBIDAS_ALCOHOLICAS=0.15;
	private double graduacion ;

	public Bebida(String nombre, String descripcion, Alergeno alergeno, double precioBase, double graduacion) {
		super(nombre, descripcion, alergeno, precioBase);
		this.graduacion=graduacion;
	}

	@Override
	public double getPrecioProducto() {
		double precio=0;
		
		if(esBebidaAlcoholica()) {
			precio=this.precioBase*IVA_BEBIDAS_ALCOHOLICAS;
		}else {
			precio=this.precioBase*IVA_GENERAL;
		}
		
		return precio;
	}

	@Override
	public boolean estaCaducado() {
		return false;
	}
	
	public boolean esBebidaAlcoholica() {
		boolean alcohol=false;
		if(graduacion>0.0) {
			alcohol=true;
		}
		
		return alcohol;
	}
	
	
}
