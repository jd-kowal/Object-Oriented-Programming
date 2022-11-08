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
		for (int i = 0; i < args.length; i++){
                	if (args[i].charAt(0) == '-'){
                    		if (args[i].contains("l")){
                        		System.out.println("wierszy: " + lines);
                    		}
                    		if (args[i].contains("c")){
                        		System.out.println("znakow: " + characters);
                    		}
                    		if (args[i].contains("w")){
                        		System.out.println("slow: " + words);
                    		}
			}
                }
	}
}
