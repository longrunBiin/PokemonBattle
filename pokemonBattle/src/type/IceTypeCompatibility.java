package type;

public class IceTypeCompatibility extends TypeCompatibility{

	public IceTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case GRASS: case GROUND: case FLYING: case DRAGON: 
                return 2.0;
            case FIRE: case WATER: case ICE: case METAL:
            	return 0.5;
            default:
                return 1.0; 
        }
    }
}
