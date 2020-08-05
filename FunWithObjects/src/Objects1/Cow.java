package Objects1;

public class Cow extends Animal{
	int tail = 8;
	
	public Cow() {
		super(Type.COW, ((int)(Math.random()*9) + 11), 4);
	}

	@Override
	public void makeNoise() {
		System.out.println("moo");
	}
	
}