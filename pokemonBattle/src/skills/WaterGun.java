package skills;

import type.Type;

public class WaterGun extends Skills{

	public WaterGun() {
		super("물수리검", Type.WATER, 5);
	}
	@Override
	public int useSkill() {
		System.out.println("use WaterGun " + name + type + damage);
		return damage;
		
	}
	@Override
	public Enum<Type> getType() {
		return Type.WATER;
	}
	
}