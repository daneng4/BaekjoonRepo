
import java.io.*;
import java.util.*;
class Main {
	static Integer[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer[n+1];
		dp[0] = dp[1] = 0;
		System.out.println(rec(n));
	}
	public static int rec(int n) {
		if(dp[n] == null) {
			if(n%6==0) {
				dp[n] = Math.min(rec(n-1), Math.min(rec(n/3), rec(n/2))) + 1;
			}
			else if(n%3 ==0) {
				dp[n] = Math.min(rec(n/3), rec(n-1)) + 1;
			}
			else if(n%2 == 0) {
				dp[n] = Math.min(rec(n/2), rec(n-1)) + 1;
			}
			else {
				dp[n] = rec(n-1) + 1;
			}
		}
		return dp[n];
	}
}
