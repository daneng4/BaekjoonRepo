import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt(); 
		
		int sum[] = new int[N+1]; 
		sum[0] = 0;
		
		for(int i = 1; i<N+1; i++) { 
			sum[i] = sum[i-1] + sc.nextInt();
		}
		
		for(int i = 0; i<M; i++) {
			int k = sc.nextInt(); int j = sc.nextInt();
			System.out.println(sum[j] - sum[k-1]); 
			 	
		}
	
		
	}

}