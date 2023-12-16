package skills;

import type.Type;

public class QuickAttack extends Skills{
	
	public QuickAttack() {
		super("전광석화", Type.NORMAL, 10);
	}

	@Override
	public void useSkill() {
		System.out.println("use quicjAttack " + name + type + damage);
		
	}
}
