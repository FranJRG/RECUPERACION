package mundo.pokemon.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Entrenador {

	private String nombre;
	private int batallasGanadas;
	private Set<Pokemon>equipoPokemon;
	
	
	
	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
		this.equipoPokemon=new HashSet<>();
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
		
		
		if(p1==null) {
			throw new PokemonException("El pokemon no se puede añadir");
		}
		if(equipoPokemon.contains(p1)) {
			throw new PokemonException("El pokemon no se puede añadir");
		}
		
		equipoPokemon.add(p1);
		return true;
	}
	
	public boolean eliminarPokemon(Pokemon p1) {
		return equipoPokemon.remove(p1);
	}
	
	public boolean eliminarPokemon(String nombre, Elemento tipo) {
		boolean eliminar=false;
		Pokemon pEliminar=null;
		for (Pokemon pokemon : equipoPokemon) {
			if(pokemon.getNombre().equals(nombre) && pokemon.getElemento().equals(tipo)) {
				pEliminar=pokemon;
			}
		}
		
		if(pEliminar!=null) {
			equipoPokemon.remove(pEliminar);
			eliminar=true;
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
		
		if(e1.equipoPokemon.isEmpty() || equipoPokemon.isEmpty()) {
			throw new PokemonException("Su equipo esta vacío");
		}
		
		for (Pokemon pokemon : equipoPokemon) {
			if(e1.equipoPokemon.contains(pokemon)) {
				
				throw new PokemonException("Tienen pokemons en comun no pueden donar");
			}	
		}
		e1.equipoPokemon.addAll(equipoPokemon);
		equipoPokemon.clear();
		return true;
	}
	
	public String mostrarPokemons() {
		StringBuilder sb=new StringBuilder();
		
		for (Pokemon pokemon : equipoPokemon) {
			if(pokemon!=null) {
				sb.append(pokemon.getNombre()).append("\n");
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
		return "Entrenador con nombre " + this.nombre + ", batallasGanadas=" + batallasGanadas + " y equipo pokemon " + mostrarPokemons();
	}
	
	
	
	
}
