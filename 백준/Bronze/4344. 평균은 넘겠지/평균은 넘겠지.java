import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			int sum = 0;
			
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}

			double avg = sum / N;
			int count = 0;
			
			for(int i = 0; i<N; i++) {
				if(arr[i] > avg) {
					count++;
				}
			}
			
			String answer = String.format("%.3f", (double)count/(double)N*100);
			System.out.println(answer + "%");
		}
		
		
	}
}
