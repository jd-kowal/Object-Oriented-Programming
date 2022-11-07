import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounterv3 {
	public static void main( String[] args ) throws IOException {	//added throw declaration
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		int howManyLines = 0;
		while (reader.readLine() != null) howManyLines++;
		reader.close();
		System.out.println("\nLiczba wierszy w pliku " + args[0] +" wynosi: " + howManyLines);
	}
}
