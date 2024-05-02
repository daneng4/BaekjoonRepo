
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			int[] dp = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 1;
			dp[0] = 1;
			
			for(int i = 1; i<n; i++) {
				dp[i] = 1;
				for(int j = 0; j<i; j++) {
					if(num[i] > num[j] && dp[j] >= dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(max, dp[i]);
			}
			bw.write(String.format("#%d %d\n", t, max));
		}
		
		bw.flush();
	
	}
}