package type;

public class PsychicTypeCompatibility extends TypeCompatibility{

	public PsychicTypeCompatibility(Enum<Type> type) {
		super(type);
	}

	@Override
    public double checkCompatibility() {
        switch ((Type)type) {
            case FIGHTING: case POISON: 
                return 2.0;
            case PSYCHIC: case METAL:
            	return 0.5;
            case DARK:
            	return 0.0;
            default:
                return 1.0; 
        }
    }
}
