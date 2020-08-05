package Objects1;

public class DataOnly {
	int number;
	String word;
	double decimal;
	boolean yes;
	
	public void print() {
		System.out.println(number + " " + word + " " + decimal + " " + yes);
	}
	
	public void setEqualTo(DataOnly dOnly1) {
		dOnly1.number = number;
		dOnly1.word = word;
		dOnly1.decimal = decimal;
		dOnly1.yes = yes;
	}
	
	public void setEqualTo(String str) {
		str = word;
	}
	
	@Override 
	public DataOnly clone() {
		DataOnly dataOnly = new DataOnly();
		setEqualTo(dataOnly);
		return dataOnly;
	}
	
//	public void setInt(int i) {
//		number = i;
//	}
	
//	public DataOnly(int number, String word, double decimal, boolean yes) {
//		this.number = number;
//		this.word = word;
//		this.decimal = decimal;
//		this.yes = yes;
//	}

}
