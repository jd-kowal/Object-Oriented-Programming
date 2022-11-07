import java.io.File;
import java.nio.file.Files;

public class FileCopyv2 {
	public static void main( String[] args) {
		if(args.length == 0) {
			System.out.println("Brak argumentów programu.\n");
			System.exit(0);
		}
		File file = new File(args[0]);
		File fileCp = new File(args[1]);
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

