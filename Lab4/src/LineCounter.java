import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader; //FileReader?
import java.util.Scanner;

public class LineCounter {
	private static int counter = 0;
	
	public LineCounter(){
		LineCounter.counter +=1;
	}
	
	public static void main( String[] args ) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		File file = new File(args[0]);
		file.canRead();
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

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		LineCounter.counter = counter;
	}
}
