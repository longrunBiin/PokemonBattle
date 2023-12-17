package pokemon;

import java.util.ArrayList;
import java.util.List;

import skills.DragonRage;
import skills.Flamethrower;
import skills.QuickAttack;
import skills.Skills;
import skills.Tackle;
import skills.ThunderBolt;
import type.Type;

public class Charmander extends Pokemon{//파이리 
	
	public Charmander() {
		model = new PokemonModel("charizard", 100, Type.FIRE, skills, "", 50, 100);
	}

	@Override
	public List<Skills> matchSkills() {
		List<Skills> skill = new ArrayList();
		skill.add(new DragonRage());
		skill.add(new Flamethrower());
		skill.add(new Tackle());
		return skill;
	}

	@Override
	public void useSkill(String skillName) {
		switch(skillName) {
		case "1" : model.skills.get(0).useSkill(); break;
		case "2" : model.skills.get(1).useSkill(); break;
		case "3" : model.skills.get(2).useSkill(); break;
		}
	}

	

}
