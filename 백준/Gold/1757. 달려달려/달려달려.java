
import java.io.*;
import java.util.*;

public class Main {
	static int[] run;
	static int[][] dp;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 운동시간
		m = Integer.parseInt(st.nextToken()); // 지침지수
		run = new int[n+1];
		dp = new int[n+1][m+1];
		
		for(int i = 1; i<=n; i++) {
			run[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = run[1];
		for(int i = 1; i<=n; i++) {
			solve(i, run[i]);
		}
		
		System.out.println(dp[n][0]);
	}
	public static void solve(int idx, int run) {
		// idx번째에 쉬는경우
		dp[idx][0] = dp[idx-1][0];
		
		// idx번째에 달리는경우
		for(int i = 1; i<=m; i++) {
			dp[idx][i] = dp[idx-1][i-1] + run;
		}
		
		// 지침지수가 0으로끝나는 경우의 최대값 저장
		for(int i = 1; i<=m && idx > i; i++) {
			dp[idx][0] = Math.max(dp[idx][0], dp[idx-i][i]);
		}
		
	}
}