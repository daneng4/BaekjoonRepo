
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=tc; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			// k층 n호 = 몇명?
			
			int[][] dp = new int[15][15];
			for(int i = 0; i<=14; i++) {
				dp[0][i] = i;
			}
			
			for(int i = 1; i<=14; i++) {
				for(int j = 1; j<=14; j++) {
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
				}
			}
			
			System.out.println(dp[k][n]);
		}
		
	}
}