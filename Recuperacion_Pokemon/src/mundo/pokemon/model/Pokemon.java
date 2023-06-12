package mundo.pokemon.model;

import java.util.Objects;
import java.util.Random;

public class Pokemon implements Comparable<Pokemon>{
	
	private String nombre;
	private Elemento elemento;
	protected int fuerza;
	private int nivel=3;
	Entrenador entrenador;
	
	
	public Pokemon(String nombre, Elemento elemento) {
		super();
		this.nombre=nombre;
		this.elemento=elemento;
	}
	
	public Pokemon luchar(Pokemon p1) throws PokemonException {
		
		if(this.fuerza>p1.fuerza) {
			this.fuerza+=10;
			p1.fuerza-=5;
			this.nivel++;
			p1.nivel--;
			this.evolucionarTrasBatalla(false);
		}else {
			p1.fuerza+=10;
			this.fuerza-=5;
			p1.nivel++;
			this.nivel--;
			p1.evolucionarTrasBatalla(false);
		}
		
		return p1;
	}
	
	public void evolucionarTrasBatalla(boolean evolucionar) {
		if(evolucionar) {
			this.nivel++;
			this.fuerza+=10;
		}
	}
	
	private int obtenerFuerzaInicial() {
		return new Random().nextInt(1,80);
	}

	public String getNombre() {
		return nombre;
	}

	public Elemento getElemento() {
		return elemento;
	}

	@Override
	public int compareTo(Pokemon o) {
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elemento, fuerza, nivel, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj || obj!=null && obj instanceof Pokemon && this.hashCode()==obj.hashCode();
	}
	
}
