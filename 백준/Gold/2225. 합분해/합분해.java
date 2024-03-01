
import java.io.*;
import java.util.*;

/*
 * 0부터 N까지의 정수 중 K개를 더해서 그 합이 N이 되는 경우의 수
 */

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[k+1][n+1]; // dp[a][b] -> a개를 더해서 b를 만드는 경우의 수
		Arrays.fill(dp[1] , 1);
		for(int i = 1; i <= k; i++) {
			dp[i][0] = 1;
		}
		for(int i = 2; i<=k; i++) {
			for(int j = 1; j<=n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= 1000000000;
			}
		}
		System.out.println(dp[k][n]);
	}
}

