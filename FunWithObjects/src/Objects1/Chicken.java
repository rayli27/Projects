package Objects1;

public class Chicken extends Animal{
	int eggs = 4;
	
	public Chicken() {
		super(Type.CHICKEN, 3, 2);
	}

	@Override
	public void makeNoise() {
		System.out.println("bok");
	}
}