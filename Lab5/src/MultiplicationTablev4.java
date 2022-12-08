import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTablev4 {
	/** special 'class' that represents a group of constants variables (unchangeable) */
	enum properties {
		VALUE_MIN,
		VALUE_MAX,
		PERCENT,
		TASKS_MIN,
		TASKS_MAX,
	}
	private static double PercentageCorrect;
	private static int TasksDone;
	private static int TasksDoneCorrect;
	
	/** getProperties - prepare setting if not existed before, returns an obj*/
	private static Properties getProperties() throws IOException{
		Properties pObj = new Properties();
		File file = null;
		file = new File("setup.properties");

		if (!file.exists()) {
			pObj.setProperty(properties.VALUE_MIN.toString(), "1");
			pObj.setProperty(properties.VALUE_MAX.toString(), "10");
			pObj.setProperty(properties.PERCENT.toString(), "70");
			pObj.setProperty(properties.TASKS_MIN.toString(), "10");
			pObj.setProperty(properties.TASKS_MAX.toString(), "25");
			
			pObj.store(new FileWriter("setup.properties"), "MultiplicationTable-SettingsFile"); //store(Writer,String)
		}
		
		FileReader reader;
		reader = new FileReader(file);
		pObj.load(reader);	//load(Reader)
		reader.close();
		return pObj;
	}
	
	/** random returns a pseudo-random random object*/
	private static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(min, max);
	}
	
	/** checking - checks if user's answer is correct*/ 
	private static boolean checking(int a, int b, int ans) {
		return a*b == ans ? true : false;
	}
	
	/** showStatus - shows user's results*/
	private static void showStatus() {
		System.out.println("\n\tStatus:");
		System.out.println("Tasks Done: " + MultiplicationTablev4.getTasksDone());
		System.out.println("Tasks Done Correct: " + MultiplicationTablev4.getTasksDoneCorrect());
		System.out.println("Percentage Correct: " + MultiplicationTablev4.getPercentageCorrect());
	}
	
	
	/** checkEnding - checks if game is done in 10 attempts or not over 25*/
	private static boolean checkEnding(Properties pObj) {
		if ((MultiplicationTablev4.getTasksDone() == Integer.parseInt(pObj.getProperty(properties.TASKS_MIN.toString())) ||  MultiplicationTablev4.getTasksDone() == Integer.parseInt(pObj.getProperty(properties.TASKS_MAX.toString())))&& MultiplicationTablev4.getPercentageCorrect() >= Integer.parseInt(pObj.getProperty(properties.PERCENT.toString()))) {
			return true;
		}else if((MultiplicationTablev4.getPercentageCorrect() > Integer.parseInt(pObj.getProperty(properties.PERCENT.toString()))) && (MultiplicationTablev4.getTasksDone() > Integer.parseInt(pObj.getProperty(properties.TASKS_MIN.toString())))){
			return true;
		} else if(MultiplicationTablev4.getTasksDone() == Integer.parseInt(pObj.getProperty(properties.TASKS_MAX.toString())) ){
			return true;
		} else {
			return false;
		}
	}
	
	/** results - shows end results*/
	private static void results(Properties pObj) {
		if (MultiplicationTablev4.getPercentageCorrect() >= Integer.parseInt(pObj.getProperty(properties.PERCENT.toString()))) { 
			System.out.print("\n\n\n\t!!! CONGRATULATIONS !!!\n");
		} else {
			System.out.print("\n\n\n\tNot too bad.   Try one more time.\n");
		}
		System.out.println("\nYour results in this game are as belowings");
		showStatus();
	}
	
	/** game - is the foreground method*/
	private static void game() throws IOException{
		System.out.print("\tMultiplication Table\n");
		boolean ifEnd = false;
		Properties pObj = getProperties();
		int MIN = Integer.parseInt(pObj.getProperty(properties.VALUE_MIN.toString()));
		int MAX = Integer.parseInt(pObj.getProperty(properties.VALUE_MAX.toString()));
		Scanner sc = new Scanner(System.in);
		while(!ifEnd) {
			int a = MultiplicationTablev4.random(MIN,MAX);
			int b = MultiplicationTablev4.random(MIN,MAX);
			System.out.println("\nPlease solve this task: ");
			System.out.println(a + " x " + b);		
			int ans = 0;
			ans = sc.nextInt();
			if (MultiplicationTablev4.checking(a, b, ans)) {
				MultiplicationTablev4.setTasksDoneCorrect(1);
				System.out.println("\n\t Congratulations! Good answer!\n");
			}else {
				MultiplicationTablev4.setTasksDoneCorrect(0);
				System.out.println("\n\t Oh, maybe next time :(   Wrong answer!\n");
			}
			MultiplicationTablev4.setTasksDone();
			MultiplicationTablev4.setPercentageCorrect();
			showStatus();
			ifEnd = checkEnding(pObj);
		}
		results(pObj);
		sc.close();
	}
	
	public static void main( String[] args) throws IOException{
		game();
	}

	public static double getPercentageCorrect() {
		return PercentageCorrect;
	}

	public static void setPercentageCorrect() { 
		PercentageCorrect = ((double)TasksDoneCorrect/TasksDone) * 100;
	}

	public static int getTasksDone() {
		return TasksDone;
	}

	public static void setTasksDone() {
		TasksDone++;
	}
	public static int getTasksDoneCorrect() {
		return TasksDoneCorrect;
	}

	public static void setTasksDoneCorrect(int x) {
		TasksDoneCorrect += x;
	}
}
