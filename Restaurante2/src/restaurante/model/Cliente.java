package restaurante.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente{ 
	
	private Alergeno alergia;
	private LocalDate fechaNacimiento;
	private String codigoCliente;
	private Producto[] consumos;
	
	
	public Cliente(LocalDate fechaNacimiento, Alergeno alergico) {
		super();
		this.fechaNacimiento=fechaNacimiento;
		this.alergia=alergico;
	}

	
	public boolean solicitarServicio(Producto s) throws ServicioNoDisponibleException {
		boolean solicitar=false;
		
		if(esBebedor() && !esMayorEdad()) {
			throw new ServicioNoDisponibleException("El servicio solicitado no está disponible para menores de edad");
		}
		
		if(s.getAlergeno().equals(s)) {
			throw new ServicioNoDisponibleException("El servicio contiene ingredientes que usted no puede tomar");
		}
		
		for(int i=0;i<consumos.length;i++) {
			if(s!=null & consumos[i]==null) {
				solicitar=true;
				consumos[i]=s;
			}
		}
		
		
		return solicitar;
	}
	

	public int compareTo(Cliente otro) {
		return 0;
	}
	

	public double calcularImporteConsumido() {
		double precioTotal=0;
		
		for(int i=0;i<=consumos.length;i++) {
			precioTotal+=consumos[i].getPrecioProducto();
		}
		
		return precioTotal;
	}
	

	public boolean esMayorEdad() {
		boolean esMayor=false;
		
		if(this.fechaNacimiento.getYear()-LocalDate.now().getYear()>=18) {
			esMayor=true;
		}
		
		return esMayor;
	}
	

	public int getEdadActual() {
		return (int) ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
	}
	
	
	public boolean esAlergicoA(Alergeno alergeno) {
		boolean alergico=false;
		
		if(this.alergia.equals(alergeno)) {
			alergico=true;
		}
		
		return alergico;
	}
	
	
	public String getCodigoCliente() {
		return codigoCliente;
	}


	public boolean esBebedor() {
		boolean esBebedor=false;
		
		for (Producto producto : consumos) {
			if(producto instanceof Bebida) {
				Bebida b=(Bebida)producto;
				if(b.esBebidaAlcoholica()) {
					esBebedor=true;
				}
			}
		}
		return esBebedor;
	}

	public void registrarConsumo(Producto producto) throws ServicioNoDisponibleException {
		
		if(esBebedor() && !esMayorEdad()) {
			throw new ServicioNoDisponibleException("El servicio no esta disponible para menores de edad");
		}
		
		if(producto.alergeno.equals(alergia)) {
			throw new ServicioNoDisponibleException("El servicio contiene ingredientes perjudiciales para su salud");
		}
		
		for(int i=0;i<consumos.length;i++) {
			if(consumos[i]==null && producto!=null) {
				consumos[i]=producto;
			}
		}
	}


	public Alergeno getAlergia() {
		return alergia;
	}


	public Producto[] getConsumos() {
		return consumos;
	}
	
	
}

