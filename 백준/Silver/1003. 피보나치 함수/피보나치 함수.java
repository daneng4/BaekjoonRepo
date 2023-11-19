
import java.io.*;
import java.util.*;
class Main {
	public static Integer[][] dp;
	public static int count1 = 0;
	public static int count0 = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();;
        int t = Integer.parseInt(br.readLine());
        
        dp = new Integer[41][2];
        dp[0][0] = 1;
    	dp[0][1] = 0;
    	dp[1][0] = 0;
    	dp[1][1] = 1;
    	
        for(int tc = 0; tc<t; tc++) {
        	int n = Integer.parseInt(br.readLine());
        	fibo(n);
        	sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
        } // end of test_case
        
        System.out.println(sb);
	}
	
	public static Integer[] fibo(int num) {
		
		if(dp[num][0] == null || dp[num][1] == null) {
			dp[num][0] = fibo(num-1)[0] + fibo(num-2)[0];
			dp[num][1] = fibo(num-1)[1] + fibo(num-2)[1];
		}
		return dp[num];
		
	}
}
