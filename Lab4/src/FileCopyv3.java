import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyv3 {
	public static void main( String[] args) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		try {
			Files.createFile(fileCpPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
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

/*
 * Paths.get();
Files.isRegularFile(file)
isDirectory()
isReadable()
isExecutable()
isSameFile(x1,x2) IOException

Files.createFile()
.createDirectory()

Files.delete()
Files.deleteIfExists()

 */


