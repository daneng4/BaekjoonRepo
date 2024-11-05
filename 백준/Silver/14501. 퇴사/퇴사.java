import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] price = new int[N];
		int[] task = new int[N];
		int[] dp = new int[N+1];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			task[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {
			if(i + task[i] <= N) {
				dp[i + task[i]] = Math.max(dp[i + task[i]], dp[i] + price[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.println(dp[N]);
	}
	
}