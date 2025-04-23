import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][2];
		dp[1][1] = 1;
		dp[2][0] = 1; dp[2][1] = 1;
		dp[3][0] = 2; dp[3][1] = 2;

		StringBuilder sb = new StringBuilder();
		for(int i = 4; i<100001; i++){
			dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % 1000000009;
			dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % 1000000009;
		}
		for(int i = 0; i<n; i++){
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][1] % 1000000009).append(" ").append(dp[num][0] % 1000000009).append("\n");
		}

		System.out.println(sb);
	}
}
