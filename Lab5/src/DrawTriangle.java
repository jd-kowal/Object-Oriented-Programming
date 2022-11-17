import java.util.Scanner;

public class DrawTriangle {
	public static void main( String[] args) {
		
		int x = 0;
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Proszę wprowadzić wysokość trójkąta: ");
			x = sc.nextInt();
			System.out.print("\n");
			if (x<2) {
				System.err.println("Wprowadzona wartość nie jest poprawna.");
				System.exit(1);
			}
		} catch (Exception e) {
			System.err.println("Wprowadzona wartość nie jest poprawna.");
			System.exit(1);
		}
		
		
		int lastRow = 1 + 2 * (x-1);
		//int lastRow = 2^(x-1)-1;
		System.out.println(lastRow);
		int middle = lastRow/2 + 1;
		System.out.println(middle);
		
		//int z = 0;
		//if(x%2 != 0) z++; 
		
		for(int i = 0; i < x; i++) {
			System.out.print("\n");
			for(int j = 0; j < middle - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				System.out.print("#");
			}
		}
		
		System.out.println("\n");
		System.out.println("\n");
		
		for(int i=0; i<x; i++) {
			System.out.printf(" %" + (x-i) + "c", '#');
			System.out.println("#".repeat(i*2));
		}
	}
}

/*
 System.out.println("#".repeat(x));
 for(int i = x - 2; i>0; i--)
 	System.out.println("#%"+(x-1)+"c/n",'#');
 System.out.println("#".repeat(x));
 */
