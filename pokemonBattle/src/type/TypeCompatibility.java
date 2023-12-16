package type;

public abstract class TypeCompatibility {
	 Enum<Type> type;

	 public TypeCompatibility(Enum<Type> type) {
	        this.type = type;
	 }
	 
	 public abstract double checkCompatibility();

}
