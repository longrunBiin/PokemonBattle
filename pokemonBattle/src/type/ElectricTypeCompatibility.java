package type;

public class ElectricTypeCompatibility extends TypeCompatibility{

	public ElectricTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case WATER: case FLYING: 
                return 2.0;
            case ELECTRIC: case GRASS: case DRAGON:
            	return 0.5;
            case GROUND:
            	return 0.0;
            default:
                return 1.0; 
        }
    }
}
