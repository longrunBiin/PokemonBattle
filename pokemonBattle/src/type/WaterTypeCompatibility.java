package type;

public class WaterTypeCompatibility extends TypeCompatibility{

	public WaterTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case FIRE: case GROUND: case ROCK:
                return 2.0;
            case GRASS: case WATER: case DRAGON: 
            	return 0.5;
            default:
                return 1.0; 
        }
    }
}
