import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LineCounterPanev2 {
	public static void main( String[] args) {
		String input = JOptionPane.showInputDialog("Please enter file name: ");
		if(input.length() == 0) {
			System.out.println("U Moron!");
			System.exit(0);
		}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(input));
			int counter = 0;
			String text = "";
			String s;
			while((s=reader.readLine()) != null) {
				counter++;
				text = text + s + "\n";
			}
			//System.out.print(text);
			reader.close();
			System.out.println("\nLiczba wierszy w pliku " + input + " wynosi: " + counter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
