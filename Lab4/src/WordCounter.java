import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class WordCounter {
	public static void main( String[] args ) throws IOException {	//added throw declaration
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		
		System.out.println(args.length);
		String command = "";
		for(int i = 0; i < args.length; i++) {
			command += args[i] + " ";
		}
		/*System.out.println(command.indexOf("abc.txt"));
		int index = command.indexOf("abc.txt")-3;	//liczy po charach
		System.out.println(args[index]);
		System.out.println(command.substring(index, index));	//liczy po stringach
		System.out.println(command.substring(command.indexOf("abc"), command.indexOf("txt") + 3));
		*/
		//System.out.print(command.substring(0, 0));
		
		BufferedReader reader = new BufferedReader(new FileReader(command.substring(command.indexOf("abc"), command.indexOf("txt") + 3)));
		int numberOfLines = 0;
		String text = "";
		String s;
		while((s=reader.readLine()) != null) {
			numberOfLines++;
			text = text + s + "\n";
		}
		
		int numberOfWords = 0;
		StringTokenizer st = new StringTokenizer(text);
		String[] array = new String[st.countTokens()];
		while (st.hasMoreTokens()) {
			array[numberOfWords] = st.nextToken();
			numberOfWords++;
		}
		
		System.out.println("\n\n" + command + "\n\n");
		reader.close();
		
		int numberOfChars = Files.lines(Paths.get("abc.txt")).mapToInt( String::length).sum();
		//test System.out.println(Files.lines(Paths.get("zzz.txt")).mapToInt( String::length).sum());
		
		switch(command) {
			case "-lc abc.txt ":
			case "-l -c abc.txt ":
				System.out.println("wierszy: " + numberOfLines);
				System.out.println("znaków: " + numberOfChars);
				break;
			case "abc.txt ":
			case "-lcw abc.txt ":
			case "-cl -w abc.txt ":
			case "-l -w -c abc.txt ":
				System.out.println("wierszy: " + numberOfLines);
				System.out.println("znaków: " + numberOfChars);
				System.out.println("słów: " + numberOfWords);
				break;
			case "abc.txt -w -c ":
			case "abc.txt -wc ":
			case "abc.txt -cw ":
				System.out.println("znaków: " + numberOfChars);
				System.out.println("słów: " + numberOfWords);
				break;
			default:
				System.out.println("\n\tError - błędne argumenty programu.\n");
				break;
		}
	}
}
