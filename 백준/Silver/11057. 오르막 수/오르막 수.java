
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		
		// 1의 자릿수에는 0부터 9까지 전부 1번씩 올 수 있다.
		for(int i = 0; i<10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<=9; j++) {
				for(int k = j; k<=9; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		bw.write(String.format("%d", dp[n][0] % 10007));
		bw.flush();
	}
}