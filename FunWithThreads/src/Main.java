
public class Main {

	public static void main(String[] args) {
//		DoIt doIt = new DoIt();
		ExceptionHandling exceptionHandling = new ExceptionHandling();

	}

}


class DoIt {
	
	public DoIt() {
		runMessyAdder();
		
	}
	
	private void runMessyAdder() {
		final int additions = 1000;
		NumberOwner numOwn = new NumberOwner();
		int addSize = 10;
		Adder[] addArray = new Adder[addSize];
		Thread[] threadArray = new Thread[addSize];
		
		for(int i = 0; i<addSize; i++) {
			addArray[i] = new Adder(additions, numOwn, i);
		}
		
//		Thread thread = new Thread(addArray[0]);
//		thread.start();
		
		for(int i = 0; i<threadArray.length; i++) {
			threadArray[i] = new Thread(addArray[i]);
			threadArray[i].start();
		}
		
	}
	
}


class NumberOwner {
	int theNum;
	
	public void addOne() {
		synchronized(this) {
		theNum++;
		}
	}
	
	public void subtractOne() {
		synchronized(this) {
		theNum--;
		}
	}

	public int getNum() {
		return theNum;
	}
	
}


class Adder implements Runnable {
	int additions;
	NumberOwner numOwn;
	int id;
	
	public Adder(int additions, NumberOwner numOwn, int id) {
		this.additions = additions;
		this.numOwn = numOwn;
		this.id = id;
	}
	
	public void doTheWork() {
		
		for(int i=0; i<additions; i++) {
			numOwn.addOne();
			numOwn.subtractOne();
		}
		
		System.out.println(id + ": " + numOwn.getNum());
	}

	@Override
	public void run() {
		doTheWork();
		
	}
	
}

