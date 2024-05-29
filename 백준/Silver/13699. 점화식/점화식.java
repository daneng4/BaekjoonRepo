import java.util.*;
import java.io.*;

public class Main {
	static Long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new Long[n+2];
		dp[0] = 1L;
		dp[1] = 1L;
		
		if(n == 0) {
			System.out.println(dp[0]);
			return;
		}
		
		solve(n);
		System.out.println(dp[n]);
	}
	public static Long solve(int n) {
		// 0~n-1 까지의 조합으로 dp[n]이 이루어지기 때문에 dp[n-1]이 null이면 재귀호출
		if(dp[n-1] == null) {
			solve(n-1);
		}

		ArrayList<int[]> comb = makeComb(n);
		dp[n] = cal(comb);
		
		return dp[n];
	}
	public static ArrayList<int[]> makeComb(int n) {
		int left = 0;
		int right = n-1;
		ArrayList<int[]> comb = new ArrayList<>();
		
		for(int i = 0; i<=n-1; i++) {
			comb.add(new int[] {left, right});
			left++;
			right--;
		}
		
		return comb;
	}
	public static long cal(ArrayList<int[]> comb) {
		long sum = 0;
		
		for(int i = 0; i<comb.size(); i++) {
			int a = comb.get(i)[0];
			int b = comb.get(i)[1];
			
			sum += dp[a] * dp[b];
		}
		
		return sum;
	}
}