

public class FloatArithmeticMeanv2 {
	public static void main( String[] args ) {
		System.out.println("\tFloatArithmeticMean\n");
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);	
		}
		float suma = 0;
		
		for (int i = 0; i < args.length; i++) {	
			suma = suma + Float.parseFloat(args[i]);
			System.out.printf("%10.3f%n",Float.parseFloat(args[i]));
		}
		System.out.println("----------");
		System.out.printf("%10.3f%n",suma);
		System.out.printf("\nŚrednia arytmetyczna: %.4f%n", suma/args.length);
	}
}
