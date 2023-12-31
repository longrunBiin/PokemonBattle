package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	Pokemon pokemon;
	List<String> skillnames;

	public Player(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public List<String> getPokemonSkill() {
		skillnames = pokemon.getSkillname(); //직렬화되지 않으므로 에러 발생 가능
		return skillnames;
	}

	public void useSkill(String skill) {
		pokemon.useSkill(skill);
	}
}
