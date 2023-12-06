package skills;

import pokemon.Type;

public abstract class Skills {
	String name;
	Type type;
	int damage;
	
	public Skills(String name, Type type, int damage) {
		this.name = name;
		this.type = type;
		this.damage = damage;
	}
	public abstract void useSkill();
	
	public int getDamage() {
		return damage;
	}
}
