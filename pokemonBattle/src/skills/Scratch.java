package skills;

import type.Type;

public class Scratch extends Skills{
	
	public Scratch() {
		super("할퀴기", Type.NORMAL, 10);
	}

	@Override
	public int useSkill() {
		System.out.println("use scratch " + name + type + damage);
		return damage;	
	}
	@Override
	public Enum<Type> getType() {
		return Type.NORMAL;
	}
}


