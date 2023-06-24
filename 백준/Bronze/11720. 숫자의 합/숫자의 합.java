import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int fn = sc.nextInt();
		String sn = sc.next();
		int sum = 0;
		
		sc.close();
		
		for(int i=0; i<fn; i++) {
			sum += sn.charAt(i)-'0';
		}
		
		System.out.println(sum);
		
	}

}