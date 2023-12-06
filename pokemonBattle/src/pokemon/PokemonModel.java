package pokemon;

import java.util.List;

import skills.Skills;

public class PokemonModel {
	public String name;
    public int health;
    Enum<Type> type;
    public List<Skills> skills;
    public String imagePath;
    public int attack;
    public int defense;


	public PokemonModel(String name, int health, Enum<Type> type, List<Skills> skills, String imagePath, int attack, int defense) {
		this.name = name;
    	this.health = health;
    	this.skills = skills;
    	this.type = type;
    	this.imagePath = imagePath;
    	this.attack = attack;
    	this.defense = defense;

	}
}
