import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloDate2 {
	public static void main(String[] args) {
		Date todaysDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("YYYY.MM.dd   HH:mm");		//Własny przepis na formatowanie
		System.out.println("Witaj! Teraz jest:  " + dateForm.format(todaysDate));
		System.out.println("Witaj! Teraz jest:  " + DateFormat.getInstance().format(new Date()));
	}
}
