import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.Reader;

public class LineCounterv2 {
	public static void main( String[] args ) throws IOException {	//added throw declaration
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		int counter = 0;
		String text = "";
		String s;
		while((s=reader.readLine()) != null) {
			counter++;
			text = text + s + "\n";
		}
		//System.out.print(text);
		reader.close();
		System.out.println("\nLiczba wierszy w pliku " + args[0] + " wynosi: " + counter);
	}
}
