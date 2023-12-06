package pokemon;

import java.util.ArrayList;
import java.util.List;

import skills.QuickAttack;
import skills.Skills;
import skills.ThunderBolt;

public class Pikachu extends Pokemon{
	
	public Pikachu() {
		model = new PokemonModel("pikachu", 100, Type.ELECTRIC, skills, "", 50, 50);
	}

	@Override
	public List<Skills> matchSkills() {
		List<Skills> skill = new ArrayList();
		skill.add(new ThunderBolt());
		skill.add(new QuickAttack());
		return skill;
	}

	@Override
	public void useSkill(String skillName) {
		switch(skillName) {
		case "1" : model.skills.get(0).useSkill(); break;
		case "2" : model.skills.get(1).useSkill(); break;
		}
	}
}



