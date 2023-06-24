import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		String str = sc.next(); 
		char chr[] = str.toCharArray(); 
		int sum = 0; 
		
		for(int i = 0; i<chr.length; i++) { 
			sum += chr[i] - '0';  
		}
		
		System.out.println(sum); 
	}

}