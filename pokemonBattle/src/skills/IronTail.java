package skills;

import type.Type;

public class IronTail extends Skills{

	public IronTail() {
		super("아이언테일", Type.METAL, 5);
	}
	@Override
	public int useSkill() {
		System.out.println("use Irontail " + name + type + damage);
		return damage;
		
	}
	@Override
	public Enum<Type> getType() {
		return Type.METAL;
	}
	
}



