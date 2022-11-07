import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
	public static void main( String[] args) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		File file = new File(args[0]);
		File fileCp = new File(args[1]);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bfReader = new BufferedReader(fileReader);
			
			String fileContent = "";
			String s;
			while((s=bfReader.readLine()) != null) {
				fileContent = fileContent + s + "\n";
			}
			FileWriter writer = new FileWriter(args[1]);
			writer.write(fileContent);
			writer.close();
			//bfReader.lines().forEach(System.out::println);
			bfReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist");
			System.exit(0);
		} catch (IOException e) {
			System.err.println("File exists, but there was IOException");
			System.exit(0);
		}
	}
}
