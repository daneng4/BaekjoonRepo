
import java.io.*;
import java.util.*;

public class Main {
	static long[][] arr;
	static long[][] dp;
	static int n;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new long[n][n];
		dp = new long[n][n];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i == n-1 && j == n-1)
					break;
				int go = (int) arr[i][j];
				if(i + go < n) {
					dp[i+go][j] += dp[i][j];
				}
				if(j+go<n) {
					dp[i][j+go] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
	}

}
