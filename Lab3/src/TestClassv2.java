import java.util.ArrayList;

public class TestClassv2 {
	private long x;
	private static int counter = 0;
	
	public TestClassv2() {
		TestClassv2.counter +=1;
		//this.x = (int) Math.random();
		this.x =  System.currentTimeMillis();
	}
	
	public void setX(double x) {
		this.x = (int) x;
	}
	public long getX() {
		return this.x;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		TestClassv2.counter = counter;
	}

	public static void main( String[] args ) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		ArrayList<TestClassv2> list = new ArrayList<TestClassv2>();
		for(int i = 0; i < Integer.parseInt(args[0]); i++) {
			list.add(new TestClassv2());
			System.out.println(getCounter() + ".  " + list.get(i).getX());	//list.get(i)
		}
		System.out.println("\nLiczba obiektów:  " + getCounter());
	}
}

