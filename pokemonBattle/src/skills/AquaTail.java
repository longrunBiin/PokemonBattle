package skills;

import type.Type;

public class AquaTail extends Skills{

	public AquaTail() {
		super("아쿠아테일", Type.WATER, 30);
	}
	@Override
	public int useSkill() {
		System.out.println("use AquaTail " + name + type + damage);
		return damage;
		
	}
	@Override
	public Enum<Type> getType() {
		return Type.WATER;
	}
	
}