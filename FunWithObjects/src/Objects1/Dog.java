package Objects1;

public class Dog extends Animal{
	int bites = 16;
	
	public Dog() {
		super(Type.DOG, 5, 4);
	}

	@Override
	public void makeNoise() {
		System.out.println("roof");
	}
	
}
