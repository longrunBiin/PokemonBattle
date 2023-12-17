package skills;

import java.io.Serializable;

import type.Type;

public abstract class Skills implements Serializable{
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
	public String getName() {
		return name;
	}
}
