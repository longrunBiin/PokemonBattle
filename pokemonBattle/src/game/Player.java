package game;

import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;

public class Player {
	List<Pokemon> pokemonList = new ArrayList<>();
	
	public Player(Pokemon pokemon){
		pokemonList.add(pokemon);
	}
	public void getPokemon() {
		for(Pokemon p : pokemonList) {
			System.out.println("my pokemon = " + p.getName());
		}
	}
	public void useSkill(String skill) {
		for(Pokemon p : pokemonList) {
			System.out.println("pokemon use= " );
			p.useSkill(skill);
		}
	}
}
