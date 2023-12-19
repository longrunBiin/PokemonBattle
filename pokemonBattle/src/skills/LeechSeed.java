package skills;

import type.Type;

public class LeechSeed extends Skills {

	public LeechSeed() {
		super("씨뿌리기", Type.GRASS, 30);
	}
	@Override
	public int useSkill() {
		System.out.println("use LeechSeed " + name + type + damage);
		return damage;
		
	}
	@Override
	public Enum<Type> getType() {
		return Type.GRASS;
	}
	
}

