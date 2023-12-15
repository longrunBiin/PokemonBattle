package game;

import pokemon.Pokemon;
import pokemon.Type;

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
            default:
            	return compatibility;
        }
	}
	
}
