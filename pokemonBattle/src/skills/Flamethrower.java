package skills;

import type.Type;

public class Flamethrower extends Skills{

	public Flamethrower() {
		super("화염방사", Type.FIRE, 30);
	}
	
	@Override
	public int useSkill() {
		System.out.println("use Flamethrower " + name + type + damage);
		return damage;
	}
	@Override
	public Enum<Type> getType() {
		return Type.FIRE;
	}
}
