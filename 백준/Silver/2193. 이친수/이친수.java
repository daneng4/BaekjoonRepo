
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Long[] dp = new Long[n+2];
		dp[0] = (long) 0;
		dp[1] = (long) 1;
		dp[2] = (long) 1;
		for(int i = 3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}
}
