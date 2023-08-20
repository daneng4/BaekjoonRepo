
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0;
		
		long expect_score[] = new long[n];
		for (int i = 0; i<n; i++) {
			expect_score[i] = sc.nextInt();
		}
		
		Arrays.sort(expect_score);
		
		for(int i = 0; i<n; i++) {
			sum = sum + Math.abs(expect_score[i] - (i+1));  
		}
		
		System.out.println(sum);
	}
}

