package skills;

import type.Type;

public class ThunderBolt extends Skills{
	
	public ThunderBolt() {
		super("10만볼트", Type.ELECTRIC, 50);
	}
	@Override
	public void useSkill() {
		System.out.println("use thunderbolt "+ name + type + damage);
		
	}

}
