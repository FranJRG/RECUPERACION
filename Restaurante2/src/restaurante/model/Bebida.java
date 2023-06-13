package restaurante.model;

public class Bebida extends Producto{

	private static final double IVA_BEBIDAS_ALC=0.15;
	private static final double IVA_GENERAL = 0.07;
	private double graduacion;
	

	public Bebida(String nombre, String descripcion, Alergeno alergeno, double precioBase, double graduacion) {
		super(nombre, descripcion, alergeno, precioBase);
		this.graduacion=graduacion;
	
	}

	@Override
	public double getPrecioProducto() {
		double precioFinal=0;
		
		if(esBebidaAlcoholica()) {
			precioFinal=this.precioBase*IVA_BEBIDAS_ALC;
		}else{
			precioFinal=this.precioBase*IVA_GENERAL;
		}
		return precioFinal;
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

	@Override
	public String toString() {
		return "Bebida: " + this.nombre + " Precio " + this.getPrecioProducto() + 
				" Presenta alergeno " + this.getAlergeno() + " graduacion " + graduacion;
	}


}
