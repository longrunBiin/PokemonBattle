package pokemon;

import java.util.ArrayList;
import java.util.List;

import skills.AquaTail;
import skills.DragonRage;
import skills.Flamethrower;
import skills.Scratch;
import skills.Skills;
import skills.Tackle;
import skills.WaterGun;
import type.Type;

public class Squirtle extends Pokemon{ //꼬북이
	
	public Squirtle() {
		skills = matchSkills();
		model = new PokemonModel("squirtle", 100, Type.WATER, skills, "", 50, 100);
	}

	@Override
	public List<Skills> matchSkills() {
		List<Skills> skill = new ArrayList();
		skill.add(new WaterGun());
		skill.add(new AquaTail());
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

