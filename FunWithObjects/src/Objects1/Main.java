package Objects1;

public class Main {
	
	public static void main(String[] args) {
		
//		JavaManipulation javaManipulation = new JavaManipulation();
		
		int herdSize = 6;
		int flockSize = 6;
		int packSize = (int)(Math.random()*4) + 1;
		
		FarmAnimal[] generic = new FarmAnimal[herdSize+flockSize+packSize];
		
		for(int i=0; i<herdSize; i++) {
			generic[i] = new Cow();
		}
		
		for(int i=0; i<flockSize; i++) {
			generic[i + herdSize] = new Chicken();
		}
		
		for(int i=0; i<packSize; i++) {
			generic[i + herdSize + flockSize] = new Dog();
		}

		for(int i = 0; i<generic.length; i++) {
			System.out.println(generic[i].getName(i) + " the " + generic[i].getType() + " that weighs " 
			+ generic[i].getWeight() + " lbs has " + generic[i].getLegs() + " legs.");
			
			generic[i].makeNoise();
		}
		
//		int fred = 10;
//		fred = 7;
//		int bob = fred;
//		bob = 5;
//		System.out.println(fred);
//		
//		Cow cow1 = new Cow();
//		Cow cow2 = cow1;
//		cow2.setWeight(50);
//		System.out.println(cow1.getWeight());
//		
//		for(int i = 0; i<generic.length; i++) {
//			if(generic[i] instanceof Cow) {
//				Cow cow = (Cow)generic[i];
//				generic[i].setWeight(50);
//				System.out.println(cow.getWeight());
//			}
//		}
//		
//		String animal = "Animal";
//		animal = "horse";
//		String farm = animal;
//		farm = "hello";
//		System.out.println(animal);
//		
//		Double number = 10.0;
//		Double count = number;
//		count = 20.0;
//		System.out.println(number);
//		
//		double number1 = 10.0;
//		double count1 = number1;
//		count1 = 20.0;
//		System.out.println(number1);
		
	}
}

