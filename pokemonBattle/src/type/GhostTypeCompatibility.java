package type;

public class GhostTypeCompatibility extends TypeCompatibility{

	public GhostTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case PSYCHIC: case GHOST: 
                return 2.0;
            case DARK:
            	return 0.5;
            case NORMAL:
            	return 0.0;
            default:
                return 1.0; 
        }
    }
}
