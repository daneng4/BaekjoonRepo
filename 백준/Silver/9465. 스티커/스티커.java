
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] score = new int[2][n];
			int[][] dp = new int[2][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<n; i++) {
				score[0][i] = Integer.parseInt(st.nextToken());
				score[1][i] = Integer.parseInt(st2.nextToken());
			}
			
			dp[0][0] = score[0][0];
			dp[1][0] = score[1][0];
			int max = Math.max(dp[0][0], dp[1][0]);
			
			for(int i = 1; i<n; i++) {
				if(i==1) {
					dp[0][i] = dp[1][0] + score[0][1];
					dp[1][i] = dp[0][0] + score[1][1];
					max = Math.max(dp[0][i], dp[1][i]);
					continue;
				}
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + score[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + score[1][i];
                max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}

