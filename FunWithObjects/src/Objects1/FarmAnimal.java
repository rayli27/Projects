package Objects1;

public interface FarmAnimal {
	
	enum Type{
		COW,
		CHICKEN,
		DOG,
	}
	
	public String getName(int i);
	
	public Type getType();
	
	public void setWeight(int weight);
	
	public int getWeight();
	
	public int getLegs();
	
	public void makeNoise();
}