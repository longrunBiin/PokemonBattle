package game;

import pokemon.Type;

public class FireTypeCompatibility extends TypeCompatibility{

	public FireTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case WATER: case GROUND: case ROCK:
                return 2.0;
            case FIRE: case GRASS: case ICE: case BUG: case METAL:
            	return 0.5;
            default:
                return 1.0; 
        }
    }
}
