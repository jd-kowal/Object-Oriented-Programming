import java.util.Scanner;

public class DrawSquare {
	public static void main( String[] args) {
		
		int x = 0;
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Proszę wprowadzić bok kwadratu: ");
			x = sc.nextInt();
			System.out.print("\n");
			if(x < 1) {
				System.err.println("Error - bad data");
				System.exit(1);
			}
		} catch (Exception e){
			System.err.println("Error - wprowadzona wartość nie jest poprawna");
			System.exit(1);
		}
		
		if (x == 1) {
			System.out.println("#");
			return;
		}
		
		for(int i = 0; i < x-1; i++)
			System.out.print("#");
		System.out.print("#\n");
		for(int i = 0; i < x - 2; i++) {
			System.out.print("#");
			for(int j = 0; j < x - 2; j++) {
				System.out.print(" ");
			}
			System.out.print("#\n");
		}
		for(int i = 0; i < x; i++)
			System.out.print("#");	
			
		
		
		//another way
		System.out.println("#".repeat(x));
		for(int i = x - 2; i>0; i--)
 			System.out.printf("#%"+(x-1)+"c\n",'#');
 		System.out.println("#".repeat(x));
	}
}
