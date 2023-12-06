package skills;

import pokemon.Type;

public class Flamethrower extends Skills{

	public Flamethrower() {
		super("화염방사", Type.FIRE, 30);
	}
	
	@Override
	public void useSkill() {
		System.out.println("use Flamethrower " + name + type + damage);
		
	}
}
