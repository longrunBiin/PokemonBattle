package type;

import pokemon.Pokemon;

public class TypeFactory {
	Enum<Type> type1;
	Enum<Type> type2;
	double compatibility = 1;

	public TypeFactory(Enum<Type> type1, Enum<Type> type2) {
		this.type1 = type1;
		this.type2 = type2;
		
	}
	
	public int checkType() {
        switch((Type)type1) {
            case FIRE:
                compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case NORMAL:
            	compatibility = new NormalTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case ELECTRIC:
            	compatibility = new ElectricTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case FLYING:
            	compatibility = new FlyingTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case POISON:
            	compatibility = new PoisonTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case GHOST:
            	compatibility = new GhostTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case PSYCHIC:
            	compatibility = new PsychicTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case ICE:
            	compatibility = new IceTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case DRAGON:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case DARK:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case ROCK:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case WATER:
            	compatibility = new WaterTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case GROUND:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case FIGHTING:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case BUG:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case METAL:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            case GRASS:
            	compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return (int)compatibility;
            default:
            	return (int)compatibility;
        }
	}
	
}
