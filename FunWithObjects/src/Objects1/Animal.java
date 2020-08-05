package Objects1;

public abstract class Animal implements FarmAnimal{

	String[] name = {"Paulette", "Jemma", "Rufus", "Aang", "Katara", "Sherlock", "Sokka", "John", "Watson", "Hubble", 
							"Mary", "Doc", "Mater", "Lightning", "Meredith", "Michael", "Scott", "Pam", "John", "Toby", "Jim",
							"Dwight", "Stanley", "Phyllis", "Cathy", "Robert", "Erin", "Andy", "Kevin", "Oscar", "Angela"};
	private Type type;
	private int weight;
	private int legs;
	
	public Animal(Type type, int weight, int legs) {
		this.type = type;
		this.weight = weight;
		this.legs = legs;
	}
	
	public String getName(int i) {
		return name[i];
	};
	
	public Type getType() {
		return type;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getLegs() {
		return legs;
	}
	
	public abstract void makeNoise();
	
}