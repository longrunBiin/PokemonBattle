package game;

import pokemon.Pokemon;
import pokemon.Type;

public class GameLogic {
	Pokemon pokemon1, pokemon2;
	double damage;
	int level = 50;
	double typeCompatibility = 1.0;
	int random = (int) (((Math.random()*255) + 217) * 255) / 100;
	
	public GameLogic(Pokemon pokemon1, Pokemon pokemon2) {
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.typeCompatibility = getTypeCompatibility(pokemon1, pokemon2);
		System.out.println(typeCompatibility);
	}
	
	private double getTypeCompatibility(Pokemon pokemon1, Pokemon pokemon2) {
		Enum<Type> type1 = pokemon1.getType();
		Enum<Type> type2 = pokemon2.getType();
		typeCompatibility = new TypeFactory(type1, type2).checkType();
		System.out.println(type1);
		return typeCompatibility;
	}

	public double calculateDamage(Pokemon pokemon1, Pokemon pokemon2) {
		damage = (pokemon1.getAttack() * pokemon1.getSkillDamage() * (level * 2 / 5 + 2 ) / pokemon2.getDefense() /50 + 2)
				* typeCompatibility + random;
		
		return damage;
	}
	
}
