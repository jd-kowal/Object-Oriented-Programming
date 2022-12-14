import java.util.Calendar;

public class Weekend2 {
	private final static String days[] = { "Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota"};
	private final static String months[] = { "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień","Wrzesień", "Październik", "Listopad", "Grudzień" };
	public static void main(String[] args) {
		int daysToWeekend = 7 - Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		System.out.println("Dzisiaj jest " + days[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1] + ", miesiąc " + months[Calendar.getInstance().get(Calendar.MONTH)] + ".");
		if (daysToWeekend == 6 || daysToWeekend == 0)
			System.out.println("Mamy weekend!");
		else
			System.out.println("Do weekendu pozostało " + daysToWeekend + " dni.");
		if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY)
			System.out.println("Dzisiaj mamy zajęcia z PO.");
		//System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
	}
}
