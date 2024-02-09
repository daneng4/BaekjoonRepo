import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+2];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i<dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println(recur(n));
	}
	public static int recur(int n) {
		
		if(dp[n] == -1)
			dp[n] = (recur(n-1) + recur(n-2))%15746;
		
		return dp[n];
	}
}