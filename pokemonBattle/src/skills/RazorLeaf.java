package skills;

import type.Type;

public class RazorLeaf extends Skills{
	
	public RazorLeaf() {
		super("잎날리기", Type.GRASS, 30);
	}
	@Override
	public int useSkill() {
		System.out.println("use RazorLeaf " + name + type + damage);
		return damage;
		
	}
	@Override
	public Enum<Type> getType() {
		return Type.GRASS;
	}
}
