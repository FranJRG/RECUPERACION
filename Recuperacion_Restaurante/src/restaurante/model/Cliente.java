package restaurante.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente implements Comparable<Cliente>{

	private LocalDate fechaNacimiento;
	private String codigoCliente;
	private Alergeno alergico;
	private Producto[] consumos;
	
	
	
	public Producto[] getConsumos() {
		return consumos;
	}

	public Cliente(LocalDate fechaNacimiento, Alergeno alergeno) {
		super();
		this.fechaNacimiento=fechaNacimiento;
		this.alergico=alergeno;
	}
	
	public boolean solicitarServicio(Producto p1) throws ServicioNoDisponibleException { //PREGUNTAR
		boolean puedeSol=false;
		
		if(p1.alergeno.equals(alergico)) {
			
			throw new ServicioNoDisponibleException("Es alergico al servicio solicitado");
			
		}if(esBebedor() && getEdadActual()<18) {
			
			throw new ServicioNoDisponibleException("Es menor de edad no puede beber");
			
		}else{
			for(int i=0;i<consumos.length;i++) {
				if(consumos[i]==p1 && consumos[i]!=null && p1!=null) {
					puedeSol=true;
				}
			}
		}
		return puedeSol;
		
	}

	public int compareTo(Cliente o) {
		return 0;
	}
	
	public double calcularImporteConsumido() {
		double preciofinal=0;
		
		for (Producto consumo : consumos) {
			preciofinal+=consumo.getPrecioProducto();
		}
		
		return preciofinal;
	}
	
	public boolean esMayorEdad() {
		
		boolean esMayor=false;
		
		if(LocalDate.now().getYear()-this.fechaNacimiento.getYear()>=18) {
			esMayor=true;
		}
		
		return esMayor;
	}
	
	public int getEdadActual() {
		
		return (int)(ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now()));
	}
	
	public boolean esAlergico(Alergeno a) {
		boolean esAlergico=false;
		
		if(a!=null) {
			esAlergico=true;
		}
		
		return esAlergico;
	}
	
	public void registrarConsumo(Producto producto) throws ServicioNoDisponibleException {
		if(getEdadActual()<18 && esBebedor()) {
			throw new ServicioNoDisponibleException("Si es menor de edad no puede beber");
		}
		if(consumos!=null) {
			int posicionVacia=-1;
			for(int i=0;i<consumos.length;i++) {
				if(consumos[i]==null) {
					posicionVacia=i;
				}
			}
			
			if(posicionVacia!=-1) {
				consumos[posicionVacia]=producto;
			}
		}
	}
	

	
	public String getCodigoCliente() {
		return this.codigoCliente;
	}
	
	public boolean esBebedor() {
		boolean esBebedor=false;
		
		for (Producto consumo : consumos) {
			if(consumo instanceof Bebida) {
				Bebida bebida=(Bebida)consumo;
				if(bebida.esBebidaAlcoholica()) {
					esBebedor=true;
				}
			}
		}
		return esBebedor;
	}

	public Alergeno getAlergico() {
		return alergico;
	}
	
	
	
}
