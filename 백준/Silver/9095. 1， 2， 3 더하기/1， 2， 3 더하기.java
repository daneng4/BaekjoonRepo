
import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i<=10; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for(int j = 0; j<T; j++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb);
	}
}
