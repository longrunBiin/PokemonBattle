package type;

public class NormalTypeCompatibility extends TypeCompatibility{

	public NormalTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case ROCK: case METAL: case FIGHTING:
            	return 0.5;
            case GHOST:
            	return 0.0;
            default:
                return 1.0; 
        }
    }
}
