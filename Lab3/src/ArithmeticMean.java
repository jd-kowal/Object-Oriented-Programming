

public class ArithmeticMean {
	public static void main( String[] args ) {
		System.out.println("\tArithmeticMean");
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		System.out.print("Średnia arytmetyczna liczb:  ");
		int suma = 0;
		for (int i = 0; i < args.length-1; i++) {
			System.out.print(args[i] + ", ");
			suma = suma + Integer.parseInt(args[i]);
		}
		System.out.print(args[args.length-1]);
		suma = suma + Integer.parseInt(args[args.length-1]);
		System.out.print("  wynosi  " + suma/args.length);
		
	}
}
