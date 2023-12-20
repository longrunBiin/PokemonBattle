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
	
	public double checkType() {
        switch((Type)type1) {
            case FIRE:
                compatibility = new FireTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case NORMAL:
            	compatibility = new NormalTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case ELECTRIC:
            	compatibility = new ElectricTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case FLYING:
            	compatibility = new FlyingTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case POISON:
            	compatibility = new PoisonTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case GHOST:
            	compatibility = new GhostTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case PSYCHIC:
            	compatibility = new PsychicTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case ICE:
            	compatibility = new IceTypeCompatibility(type2).checkCompatibility(); return compatibility;
            case WATER:
            	compatibility = new WaterTypeCompatibility(type2).checkCompatibility(); return compatibility;

            default:
            	return (int)compatibility;
        }
	}
	
}
