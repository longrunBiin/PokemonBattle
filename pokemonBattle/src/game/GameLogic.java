package game;

import pokemon.Pokemon;
import skills.Skills;
import type.Type;
import type.TypeFactory;

public class GameLogic {
	Pokemon pokemon;
	Skills skill;
	double damage;
	int level = 10;
	double typeCompatibility = 1;
	int random = (int) (((Math.random()*100)) * 100) / 100;
	
	public GameLogic(Skills skill, Pokemon pokemon) {
		this.pokemon = pokemon;
		this.skill = skill;
		this.typeCompatibility = getTypeCompatibility(skill, pokemon);
		System.out.println(typeCompatibility);
	}
	
	private double getTypeCompatibility(Skills skill, Pokemon pokemon) {
		Enum<Type> type1 = skill.getType();
		Enum<Type> type2 = pokemon.getType();
		typeCompatibility = new TypeFactory(type1, type2).checkType();
		System.out.println(type1);
		return typeCompatibility;
	}

	public double calculateDamage(Pokemon pokemon1, Pokemon pokemon2) {
		damage = (pokemon1.getAttack() * pokemon1.getSkillDamage()/10 * (level / 5 + 2 ) / pokemon2.getDefense() /50 + 2)
				* typeCompatibility * random/5;
		
		return damage;
	}
	
}
