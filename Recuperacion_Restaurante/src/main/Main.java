package main;

import java.time.LocalDate;

import restaurante.model.Alergeno;
import restaurante.model.Cliente;

public class Main {

	public static void main(String[] args) {
		Cliente c= new Cliente(LocalDate.of(2002, 12, 4), Alergeno.GLUTEN);
		
		System.out.println(c.esMayorEdad());
		System.out.println(c.getEdadActual());
		System.out.println(c.esAlergico(null));

	}

}
