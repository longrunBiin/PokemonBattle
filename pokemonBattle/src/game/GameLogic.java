package game;

import pokemon.Pokemon;

public class GameLogic {
	Pokemon pokemon;
	double damage;
	int level = 50;
	int typeCompatibility = 1;
	int random = 1;
	
	public GameLogic(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public double calculateDamage(Pokemon pokemon) {
		damage = (pokemon.getAttack() * pokemon.getSkillDamage() * (level * 2 / 5 + 2 ) / pokemon.getDefense() /50 + 2)
				* typeCompatibility * random;
				
		return damage;
	}
	
}
