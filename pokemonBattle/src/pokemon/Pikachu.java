package pokemon;

import java.util.ArrayList;
import java.util.List;

import skills.IronTail;
import skills.QuickAttack;
import skills.Skills;
import skills.Tackle;
import skills.ThunderBolt;
import type.Type;

public class Pikachu extends Pokemon{
	
	public Pikachu() {
		skills = matchSkills();
		model = new PokemonModel("pikachu", 100, Type.ELECTRIC, skills, "/image/Pikachu_front.png", 150, 50);
	}

	@Override
	public List<Skills> matchSkills() {
		List<Skills> skill = new ArrayList();
		skill.add(new ThunderBolt());
		skill.add(new QuickAttack());
		skill.add(new Tackle());
		skill.add(new IronTail());
		return skill;
	}

	@Override
	public int useSkill(String skillName) {
		int damage = 0;
		switch(skillName) {
        case "1":
            damage = model.skills.get(0).useSkill();
            break;
        case "2":
            damage = model.skills.get(1).useSkill();
            break;
        case "3":
            damage = model.skills.get(2).useSkill();
            break;
        case "4":
            damage = model.skills.get(3).useSkill();
            break;
        
    }
    return damage;

	
	}
}



