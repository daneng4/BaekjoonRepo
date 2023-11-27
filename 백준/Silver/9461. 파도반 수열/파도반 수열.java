
import java.io.*;
import java.util.*;

public class Main {
	public static Long[] dp = new Long[101];
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		dp[0] = (long) 0;
		dp[1] = (long) 1;
		dp[2] = (long) 1;
		dp[3] = (long) 1;
		dp[4] = (long) 2;
		
		for(int t = 0; t<test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 5; i<=n; i++) {
				find(i);
			}
			System.out.println(dp[n]);
		} // end of testcase for loop
		
	}
	public static void find(int n) {
		if(dp[n] == null) {
			dp[n] = dp[n-1] + dp[n-5];
		}
	}
}
