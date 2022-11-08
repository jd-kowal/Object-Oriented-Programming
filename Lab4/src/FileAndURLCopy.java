import java.io.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URLConnection;
//import java.net.URLPermission

public class FileAndURLCopy {
	public static void main( String[] args) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		
		
		if(args[0].indexOf(".txt") == -1) {
			Path targetFile = Paths.get("AGH.html");
		         
		        URI uri = URI.create(args[0]);
		         
		    	try (InputStream inputStream = uri.toURL().openStream()) {
		        	Files.copy(inputStream, targetFile);
				} catch (MalformedURLException e) {
					System.out.println("Internet is not connected or bad URL");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Internet is not connected or url servisce unavailable");
					e.printStackTrace();
				}
			System.exit(0);
		}
		
		
		String DIR = "C:/Users/user/eclipse-workspace/Lab4";
		File file = new File(args[0]);
		Path filePath = Paths.get(DIR + "/" + args[0]);
		File fileCp = new File(args[1]);
		Path fileCpPath = Paths.get(DIR + "/" + args[1]);
		if (fileCp.exists() == true) {
			try {
				Files.delete(fileCpPath);
			} catch (IOException e) {		
				e.printStackTrace();
			}
		}
		
		if (file.exists() == false) {
			System.out.println("Plik " + args[0] + " nie istnieje.");
			System.exit(0);
		}
		if (file.isDirectory() == true) {
			System.out.println(args[0] + " jest katalogiem.");
			System.exit(0);
		}
		if (Files.isReadable(filePath) == false) {
			System.out.println("Brak dostępu do pliku " + args[0]);
			System.exit(0);
		}
		if (Files.isWritable(fileCpPath) == false && fileCp.exists() == true) { ////////////
			System.out.println("Nie można nadpisać pliku " + args[1]);
			System.exit(0);
		}
		if (Files.isExecutable(fileCpPath) == false && Files.isRegularFile(filePath) == true && fileCp.exists() == true) { ///////////////////////
			System.out.println("Brak wymaganych uprawnień do zapisu pliku " + args[1]);
			System.exit(0);
		}
		if (Files.isExecutable(fileCpPath) == false && Files.isDirectory(filePath) == true && fileCp.exists() == true) { ///////////////////////////////
			System.out.println("Brak wymaganych uprawnień do katalogu " + args[1]);
			System.exit(0);
		}
		try {
			Files.copy(file.toPath(), fileCp.toPath());
		} catch (Exception e) {
			System.out.println("Error");
		}

	}
}
