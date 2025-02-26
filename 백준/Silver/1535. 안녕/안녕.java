import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = 99;
		
		int[][] dp = new int[n+1][k+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] health = new int[n+1];
		for(int i = 1; i<=n; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] happy = new int[n+1];
		for(int i = 1; i<=n; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=k; j++) {
				if(health[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j-health[i]] + happy[i], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}