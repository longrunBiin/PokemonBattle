package type;

public class FlyingTypeCompatibility extends TypeCompatibility{

	public FlyingTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case GRASS: case FIGHTING: case BUG:
                return 2.0;
            case ELECTRIC: case ROCK: case METAL:
            	return 0.5;
            default:
                return 1.0; 
        }
    }
}
