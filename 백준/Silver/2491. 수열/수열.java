import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 1;
		int max = 1;
		for(int i = 1; i<n; i++) {
			dp[i] = 1;
			if(arr[i] >= arr[i-1]) {
				dp[i] = dp[i-1] + 1;
				max = Math.max(max, dp[i]);
			}
		}
		
		for(int i = 1; i<n; i++) {
			dp[i] = 1;
			if(arr[i] <= arr[i-1]) {
				dp[i] = dp[i-1] + 1;
				max = Math.max(max,  dp[i]);
			}
		}
		
		System.out.println(max);
	}
}