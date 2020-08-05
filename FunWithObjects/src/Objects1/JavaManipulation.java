package Objects1;

public class JavaManipulation {
	
	public JavaManipulation() {
		DataOnly d0 = new DataOnly();
		DataOnly dataOnly2 = new DataOnly();
		DataOnly dataOnly3 = new DataOnly();
		d0.print();
		dataOnly2.print();
		dataOnly3.print();
		
		d0.number = 1;
		dataOnly2.number = 2;
		dataOnly3.number = 3;
		
		d0.print();
		dataOnly2.print();
		dataOnly3.print();
		
		dataOnly2 = d0.clone();
		dataOnly3 = d0.clone();
		
		d0.print();
		dataOnly2.print();
		dataOnly3.print();
		
		dataOnly2.yes = !dataOnly2.yes;
		
		d0.print();
		dataOnly2.print();
		dataOnly3.print();

		d0.setEqualTo(dataOnly2);
		dataOnly2.word = "fred";
		d0.setEqualTo("tom");
		
		d0.print();
		dataOnly2.print();
		dataOnly3.print();
		
		int g = 7;
		g = doubleValue(g);
		System.out.println(g);
		
		setMe(d0);
		d0.print();
		
		Double x = 20.0;
		setMe(x);
		System.out.println(x);
	}
	
	public int doubleValue(int n) {
		return 2*n;
	}
	
	public void setMe(DataOnly d) {
		d.number = 5;
	}
	
	public void setMe(Double str) {
		str = 10.0;
	}
	
}

//0 null 0.0 false
//0 null 0.0 false
//0 null 0.0 false
//1 null 0.0 false
//2 null 0.0 false
//3 null 0.0 false
//1 null 0.0 false
//1 null 0.0 false
//1 null 0.0 false
//1 null 0.0 false
//1 null 0.0 true
//1 null 0.0 false