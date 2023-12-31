package pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import skills.Skills;
import type.Type;

public abstract class Pokemon implements Serializable{
	private static final long serialVersionUID = 1L;

	PokemonModel model;
	List<Skills> skills = matchSkills();

    public abstract int useSkill(String skillName);
    
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
    public int getHp() {
    	return model.health;
    }
    public List<Skills> getSkills(){
    	return skills;
    }
    public int getSkillDamage() {
    	return skills.get(0).getDamage();
    }
    public List<String> getSkillname() {
    	List<Skills> skills = matchSkills();
    	List<String> skillNames = new ArrayList<>();
    	for(int i=0;i<skills.size();i++) {
    		skillNames.add(skills.get(i).getName()) ;
    	}
    		
    	return skillNames;
    }
    public Enum<Type> getType() {
    	return model.type;
    }
}

