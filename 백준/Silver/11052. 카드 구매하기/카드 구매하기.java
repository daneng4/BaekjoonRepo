import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] p = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		
		// i : 현재까지 살 수 있는 최대 카드 개수
		for(int i = 1; i<=N; i++) {
			for(int j = 0; j<i; j++) {
				dp[i] = Math.max(dp[i], p[i-j-1] + dp[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}