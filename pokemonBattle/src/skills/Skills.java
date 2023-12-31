package skills;

import java.io.Serializable;

import type.Type;

public abstract class Skills implements Serializable{
	String name;
	Enum<Type> type;
	int damage;
	
	public Skills(String name, Type type, int damage) {
		this.name = name;
		this.type = type;
		this.damage = damage;
	}
	public abstract int useSkill();
	
	public int getDamage() {
		return damage;
	}
	public String getName() {
		return name;
	}
	public abstract Enum<Type> getType();
}
