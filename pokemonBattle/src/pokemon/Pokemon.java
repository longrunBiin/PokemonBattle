package pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import skills.Skills;

public abstract class Pokemon {
	PokemonModel model;
	List<Skills> skills = matchSkills();

    public abstract void useSkill(String skillName);
    
    public abstract List<Skills> matchSkills();
    
    public String getName() {
		return model.name;
	}
    
    public int getAttack() {
    	return model.attack;
    }
    
    public int getDefense() {
    	return model.defense;
    }
    
    public int getSkillDamage() {
    	return skills.get(0).getDamage();
    }
    public Enum<Type> getType() {
    	return model.type;
    }
}

