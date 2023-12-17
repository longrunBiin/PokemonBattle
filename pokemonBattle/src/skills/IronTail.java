package skills;

import type.Type;

public class IronTail extends Skills{

	public IronTail() {
		super("아이언테일", Type.METAL, 5);
	}
	@Override
	public void useSkill() {
		System.out.println("use Irontail " + name + type + damage);
		
	}
	
}



