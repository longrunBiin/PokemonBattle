package skills;

import type.Type;

public class DragonRage extends Skills{

	public DragonRage() {
		super("용의분노", Type.DRAGON, 30);
	}

	@Override
	public int useSkill() {
		System.out.println("use DragonRage " + name + type + damage);
		return damage;
	}
}
