import java.util.Date;

public class Weekend {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//System.out.println("Hello!");
		Date todaysDate = new Date();
		//SimpleDateFormat dateForm = new SimpleDateFormat("YY.MM.dd   H:m");
		//System.out.println("Witaj! Teraz jest:  " + dateForm.format(todaysDate));
		System.out.println(todaysDate);
		//day = getDay(); -- replaced by belowings
		//Calendar cal = new Calendar();
		System.out.println(todaysDate.getDay());
		//todaysDay = Calendar.get(Calendar.DAY_OF_WEEK);
		int dayOfWeek = todaysDate.getDay();
		int daysToSaturday = 6 - dayOfWeek;
		System.out.println("Days to Saturday: " + daysToSaturday);
	}
}
