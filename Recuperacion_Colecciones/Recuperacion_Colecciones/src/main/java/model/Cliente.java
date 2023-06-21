package main.java.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {

	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;
	private Pedido p;
	private Producto producto;
	private static int secuencia=0;

	public Cliente(int id) {
		this.id=Cliente.secuencia++;
	}

	public Cliente( String nombre, String apellidos, String email, String dni, LocalDate fechaNacimiento,Genero genero) {
		super();
		this.id=Cliente.secuencia++;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}
	
	public int getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	
	public boolean esMayorEdad() {
		boolean esMayor=false;
		
		if(getEdad()>=18){
			esMayor=true;
		}
		return esMayor;
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
	
	public Pedido getP() {
		return p;
	}
	
	public void setPedido(Pedido p) {
		this.p=p;
	}
	
	public Producto getProducto() {
		return producto;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s, %s", this.id, this.nombre, this.apellidos, this.dni, this.email, this.fechaNacimiento, this.genero);
	}
	
}
