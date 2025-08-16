import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int[][] dp;
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k+1][n+1]; // dp[a][b] : a개를 더해 b를 만드는 경우의 수를 의미
		
		Arrays.fill(dp[1], 1); // 1개를 사용해서 b를 만드는 경우는 자기 자신이 존재함
		
		for(int i = 1; i<=k; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 2; i<=k; i++) {
			for(int j = 1; j<= n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] = dp[i][j] % 1000000000;
			}
		}
		
		System.out.println(dp[k][n]);
	}
}