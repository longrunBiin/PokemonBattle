package pokemon;

import java.util.ArrayList;
import java.util.List;

import skills.DragonRage;
import skills.Flamethrower;
import skills.QuickAttack;
import skills.Scratch;
import skills.Skills;
import skills.Tackle;
import skills.ThunderBolt;
import type.Type;

public class Bulbasaur extends Pokemon{//파이리 
	
	public Bulbasaur() {
		skills = matchSkills();
		model = new PokemonModel("bulbasaur", 100, Type.FIRE, skills, "", 50, 100);
	}

	@Override
	public List<Skills> matchSkills() {
		List<Skills> skill = new ArrayList();
		skill.add(new DragonRage());
		skill.add(new Flamethrower());
		skill.add(new Tackle());
		skill.add(new Scratch());
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
