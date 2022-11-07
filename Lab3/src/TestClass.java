import java.util.ArrayList;

public class TestClass {
	
	private int x;
	private double z;
	private Long[] pola;
	
	
	public TestClass() {
		//setX(0);
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = (int) x;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public void obliczZ() { 	//Object[] tab
		//ArrayList<Long> list = new ArrayList<Long>();		działało z tym
		//Object Long = tab[this.x];
		/*for (int i=0; i<this.x; i++) {
			list.add((long) Math.random());
		}*/
		this.pola = new Long[this.x];
		for (int i=0; i<this.x; i++) {
			this.pola[i] = (long) Math.random();
		}
	}
	
	public void wynik() {
		for(int i = 1; i <= pola.length; i++) {
			System.out.println(i + ".  " + pola[i-1]);
		}
		System.out.println("\nLiczba obiektów:  " + x);
	}
	/*
	public double potegowanie() {
		return pow(x,x);
	}
	*/
	public static void main( String[] args ) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
		}else {
			TestClass klasa = new TestClass();
			klasa.setX(Double.parseDouble(args[0]));
			System.out.print(klasa.x);
			System.out.println("\n");
			
			System.out.print(klasa.z);
			System.out.println("\n");
			System.out.print(klasa.pola);
			System.out.println("\n");
			klasa.obliczZ();
			System.out.print(klasa.pola);
			System.out.println("\n");
			klasa.wynik();
			System.out.print(klasa.pola[1]);
		}	
	}

	public void setWhich(int i) {
		// TODO Auto-generated method stub
		
	}
}
