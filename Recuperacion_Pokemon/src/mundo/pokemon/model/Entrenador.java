package mundo.pokemon.model;

import java.util.Objects;
import java.util.Set;

public class Entrenador {

	private String nombre;
	private int batallasGanadas;
	private Set<Pokemon>equipoPokemon;
	
	
	
	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void competir(Entrenador e1) throws PokemonException {
		Pokemon p1= this.obtenerMasFuerte();
		Pokemon p2=this.obtenerMasFuerte();
		
		if((e1.obtenerMasFuerte().luchar(this.obtenerMasFuerte())!=null)) {
			p1.evolucionarTrasBatalla(true);
			p2.evolucionarTrasBatalla(false);
			e1.equipoPokemon.add(this.obtenerMasFuerte());
			this.equipoPokemon.remove(this.obtenerMasFuerte());
			e1.batallasGanadas++;
		}else {
			p1.evolucionarTrasBatalla(false);
			p2.evolucionarTrasBatalla(true);
			this.equipoPokemon.add(e1.obtenerMasFuerte());
			e1.equipoPokemon.remove(e1.obtenerMasFuerte());
			this.batallasGanadas++;
		}
	}
	
	public boolean addPokemon(Pokemon p1) throws PokemonException {
		boolean añadir=false;
		
		for (Pokemon pokemon : equipoPokemon) {
			if(p1!=null && !pokemon.equals(p1)) {
				añadir=true;
				equipoPokemon.add(p1);
			}else {
				throw new PokemonException("El pokemon ya existe o no se puede añadir un pokemon nulo");
			}
		}
		
		return añadir;
	}
	
	public boolean eliminarPokemon(Pokemon p1) {
		boolean eliminar=false;
		
		for (Pokemon pokemon : equipoPokemon) {
			if(pokemon.equals(p1) && equipoPokemon.contains(pokemon) && pokemon!=null) {
				eliminar=true;
				equipoPokemon.remove(pokemon);
			}
		}
		
		return eliminar;
	}
	
	public boolean eliminarPokemon(String nombre, Elemento tipo) {
		boolean eliminar=false;
		
		for (Pokemon pokemon : equipoPokemon) {
			if(pokemon.getNombre().equals(nombre) && pokemon.getElemento().equals(tipo) && equipoPokemon.contains(pokemon)) {
				eliminar=true;
				equipoPokemon.remove(pokemon);
			}
		}
		
		return eliminar;
	}
	
	public void vaciar() {
		this.equipoPokemon.clear();
	}
	
	protected Pokemon obtenerMasFuerte() {
		Pokemon p1=null;
		int maxFuerza=Integer.MIN_VALUE;
		
		for (Pokemon pokemon : equipoPokemon) {
			if(pokemon!=null && pokemon.fuerza>maxFuerza) {
				pokemon=p1;
				maxFuerza=pokemon.fuerza;
				
			}
		}
		
		return p1;
		
	}
	
	public boolean donar(Entrenador e1) throws PokemonException {
		boolean donar=false;
		Entrenador e2=null;
		
		if(e1.equipoPokemon.isEmpty() || e2.equipoPokemon.isEmpty()) {
			throw new PokemonException("Su equipo esta vacío");
		}
		
		for (Pokemon pokemon : equipoPokemon) {
			if(e1.equipoPokemon.contains(pokemon)) {
				donar=false;
				throw new PokemonException("Tienen pokemons en comun no pueden donar");
			}else {
				donar=true;
				e1.equipoPokemon.addAll(e2.equipoPokemon);
				e2.equipoPokemon.clear();
			}
		}
		
		
		
		
		
		return donar;
		
	}
	
	public String mostrarPokemons() {
		StringBuilder sb=new StringBuilder();
		
		for (Pokemon pokemon : equipoPokemon) {
			if(pokemon!=null) {
				sb.append(pokemon);
			}
		}
		
		return sb.toString();		
	}


	@Override
	public int hashCode() {
		return Objects.hash(batallasGanadas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj || obj!=null && obj instanceof Entrenador && this.hashCode()==obj.hashCode();
	}

	@Override
	public String toString() {
		return "Entrenador con nombre " + nombre + ", batallasGanadas=" + batallasGanadas + " y equipo pokemon " + mostrarPokemons();
	}
	
	
	
	
}
