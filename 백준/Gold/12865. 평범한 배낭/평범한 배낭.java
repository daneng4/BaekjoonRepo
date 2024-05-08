
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=k; j++) {
				// 만약 현재 무게가 현재 감당할 수 있는 무게보다 크면
				// 이전 무게의 value를 가져온다 => 더이상 가방에 담을 수 없음
				if(w[i] > j)
					dp[i][j] = dp[i-1][j];
				// 뭔가 더 담을 수 있다면 현재 무게와 동일한 이전 무게에 현재 무게, 현재 value를
				// 더한 것을 비교하여 큰 값을 저장한다
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
			}
		}
		
		System.out.println(dp[n][k]);
	}
}