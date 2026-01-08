import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());

		Arrays.fill(dp, -1);
		
		dp[first] = 0; // 꽃을 하나만 고른 경우, 인접한 꽃이 없어서 0
		
		for(int i = 1; i<N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			int best = -1;
			
			for(int pre = 1; pre<=100; pre++) {
				if(dp[pre] != -1) {
					int val = dp[pre] + (cur - pre) * (cur - pre);
					best = Math.max(val, best);
				}
			}
			
			dp[cur] = Math.max(dp[cur], best);
		}
		
		int answer = 0;
		for(int i = 1; i<=100; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}