import java.util.ArrayList;

public class FloatArithmeticMean {
	public static void main( String[] args ) {
		System.out.println("\tFloatArithmeticMean");
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		float suma = 0;
		int HowLong = 0;
		ArrayList<Float> list = new ArrayList<Float>();
			
		for (int i = 0; i < args.length; i++) {
			suma = suma + Float.parseFloat(args[i]);
			if(args[i].length() >= HowLong) {
				HowLong = args[i].length() + 3;
			}
			list.add(Float.parseFloat(args[i]));
		}
			
		for (int j = 0; j < list.size(); j++) {
			int z = HowLong - Float.toString(list.get(j)).length();
			while(z!=0) {
				System.out.print(" ");
				z--;
			}
			
			System.out.print(Float.toString(list.get(j)) + "\n");
		}
		for (int k = 0; k < HowLong; k++)
			System.out.print("-");
		System.out.print("\n");
		int z = HowLong - Float.toString(suma).length();
		while(z!=0) {
			System.out.print(" ");
			z--;
		}
		System.out.print(suma + "\n\n");
		System.out.print("Średnia arytmetyczna:  " + suma/args.length);
	}
}
