import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineArguments {
	public static void main( String[] args ) {
		/*String[] tab = new String[5];
		System.out.println("Hello!!!");
		System.out.println("\n\tProgram vol. 1.0");
		System.out.println("\t(znana ilość danych)");*/
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Jaką ilość danych wprowadzisz?  ");
		int x = sc.nextInt(); 
		String[] dane = new String[x];
		System.out.println("Wprowadz dane:  ");
		//String dane = (String) scan.nextLine();
		System.out.println("Liczba argumentów:  " + x);
		for (int i = 1; i <= x; i++) {
			//System.out.println();
			String dana = (String) sc.next();
			System.out.println(i + ".   " + dana);
		}
		//System.out.println(dane);
		
		System.out.println("\n\n\tOpcja vol. 2.0");
		System.out.println("\t("NIE"znana ilość danych)"); //ZNANA UŻYWAM PRZECIEŻ X
		System.out.println("Wprowadz dane:  ");
		int tabDl = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i<=x; i++ ) {
			String odczyt = (String) sc.next();
			System.out.println(odczyt);
			list.add(odczyt);
		}
		System.out.println(list);
		System.out.println("\n\tWynik programu vol. 2.0");
		System.out.println("Liczba argumentów:  " + list.size());
		for (int j = 0; j < list.size(); j++)
			System.out.println(j+1 + ".  " + list.get(j));
		*/
		System.out.println("\n\n\tOpcja vol. 3.0 (while)");
		ArrayList<String> list2 = new ArrayList<String>();
		System.out.println("Wprowadz dane:  ");
		while(sc.hasNext()) {	//sc.hasNext() - blokuje sie czekając na nowe dane :(
			System.out.println("--------------------");
			String odczyt2 = (String) sc.next();
			//if (sc.nextByte() == '\n')
				//break;
			System.out.println(odczyt2);
			list2.add(odczyt2);
			//boolean istnieje = sc.hasNext();
			//System.out.println(istnieje);
			System.out.println("!!!!!!!111");	
		}
		System.out.println(list2);
		
		//Jak wyjść z tego while? jeżeli hasNext czeka na wprowadzenie następnej zmiennej?
		//Delimiter? działa tylko na tekst
		
		
		//System.out.println(dane[0]);
		/*System.out.println(tabLength);
		for (int i = 1; i <= x; i++) {
			System.out.println(i);
		}
		*/
		/*
		String input = "Ala ma kota";
		Scanner s = new Scanner(input).useDelimiter("\\s* \\s*");
		System.out.print(s.nextInt());
		*/
	}
}
