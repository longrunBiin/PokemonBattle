package skills;

import type.Type;

public class Tackle extends Skills{
	
	public Tackle() {
		super("몸통박치기", Type.NORMAL, 5);
	}
	@Override
	public int useSkill() {
		System.out.println("use Tackle " + name + type + damage);
		return damage;
		
	}
}


