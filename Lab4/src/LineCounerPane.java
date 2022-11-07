import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LineCounerPane {
	public static void main( String[] args) {
		String input = JOptionPane.showInputDialog("Please enter file name: ");
		if(input.length() == 0) {
			System.out.println("U Moron!");
			System.exit(0);
		}
		System.out.println("Thank you :)");
		
		File file = new File(input);
		String fileContent = "";
		int lines = 0;
		Scanner scan;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				fileContent = fileContent.concat(scan.nextLine() + "\n");
				lines ++;	//counter?
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(fileContent);
		System.out.println("\nLiczba wierszy w pliku abc.txt wynosi: " + lines);
	}
}
