
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] w = new int[n+1];
			int[] c = new int[n+1];

			for(int i = 1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[n+1][k+1];
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=k; j++) {
					if(w[i] > j)
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + c[i]);
				}
			}
			
			bw.write(String.format("#%d %d\n", t, dp[n][k]));
		} // testcase
		bw.flush();
	}

}