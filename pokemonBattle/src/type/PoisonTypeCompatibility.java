package type;

public class PoisonTypeCompatibility extends TypeCompatibility{

	public PoisonTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case GRASS:
                return 2.0;
            case POISON: case GROUND: case ROCK: case GHOST: 
            	return 0.5;
            case METAL:
            	return 0.0;
            default:
                return 1.0; 
        }
    }
}
