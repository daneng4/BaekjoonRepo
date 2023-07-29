import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		
		
		int arr[] = new int[N];
		
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i =0; i<N-1; i++) {
			for(int j =i+1; j<N; j++) {
				if(arr[i] + arr[j] == M) {
					cnt = cnt + 1;
				}
			}
		}
		System.out.println(cnt);
	}

}
