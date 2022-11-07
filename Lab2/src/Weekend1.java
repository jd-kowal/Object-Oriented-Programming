import java.util.Date;

public class Weekend1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		int day = date.getDay();
		if (day == 6 || day == 0) {
			System.out.println("Dziś jest weekend!\n");
		}
		else {
			switch(day) {
			case 1:
				System.out.println("Dziś jest poniedziałek.\n");
				break;
			case 2:
				System.out.println("Dziś jest wtorek.\n");
				break;
			case 3:
				System.out.println("Dziś jest środa.\n");
				break;
			case 4:
				System.out.println("Dziś jest czwartek.\n");
				break;
			case 5:
				System.out.println("Dziś jest piątek.\n");
				break;
			default:
				System.out.println("Błąd");
				break;
			}
		}
	}
}
