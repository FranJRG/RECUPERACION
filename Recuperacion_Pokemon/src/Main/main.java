package Main;

import mundo.pokemon.model.Elemento;
import mundo.pokemon.model.Entrenador;
import mundo.pokemon.model.Pokemon;
import mundo.pokemon.model.PokemonException;

public class main {

	public static void main(String[] args)  {
		
		try {
			
			Entrenador e1=new Entrenador("Francisco Javier");
			Entrenador e2=new Entrenador("Alfonso Ramirez");
			
			Pokemon p1=new Pokemon("Pikachu", Elemento.ELECTRICO);
			Pokemon p2=new Pokemon("Celebi", Elemento.HADA);
			Pokemon p3=new Pokemon("Gyarados", Elemento.AGUA);
			Pokemon p4=new Pokemon("Onix", Elemento.ROCA);
			Pokemon p5=new Pokemon("Articuno", Elemento.VOLADOR);
			Pokemon p6=new Pokemon("Infernape", Elemento.FUEGO);
			
			e1.addPokemon(p1);
			e1.addPokemon(p2);
			e1.addPokemon(p3);
			
			e2.addPokemon(p4);
			e2.addPokemon(p5);
			e2.addPokemon(p6);
			
			System.out.println(e1.mostrarPokemons().toString());
			System.out.println(e2.mostrarPokemons().toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
