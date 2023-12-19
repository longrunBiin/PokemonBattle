package skills;

import type.Type;

public class QuickAttack extends Skills{
	
	public QuickAttack() {
		super("전광석화", Type.NORMAL, 30);
	}

	@Override
	public int useSkill() {
		System.out.println("use quicjAttack " + name + type + damage);
		return damage;
		
	}
	@Override
	public Enum<Type> getType() {
		return Type.NORMAL;
	}
}
